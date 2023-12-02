package org.wireforce.virbet.classes

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.math.BigInteger
import java.security.MessageDigest

@Serializable
class ESL2(private val sports: List<Sport>) {
	@Serializable
	@Contextual
	private val operations: MutableList<Operation<@Contextual Any>> = mutableListOf()

	fun getOperations() = operations

	fun getSportsScope() = sports

	companion object {
		infix fun ESL2.select(init: ESL2.() -> Unit): ESL2 {
			init()
			return this
		}

		fun <T: Any> not(values: Operation<T>): Operation<T> {
			return Operation(
				values.name,
				values.comparison,
				values.value,
				true
			)
		}


		infix fun <T: Any> Named.eq(value: OperationsGroup<T>): Operation<T> {
			return Operation(
				this,
				Comparison.EQ,
				value
			)
		}

		infix fun Named.like(value: OperationsGroup<String>): Operation<Any> {
			return Operation(
				this,
				Comparison.LIKE,
				value
			) as Operation<Any>
		}

		infix fun Named.lt(value: OperationsGroup<Double>): Operation<Any> {
			return Operation(
				this,
				Comparison.LT,
				value
			) as Operation<Any>
		}

		infix fun Named.gt(value: OperationsGroup<Double>): Operation<Any> {
			return Operation(
				this,
				Comparison.GT,
				value
			) as Operation<Any>
		}

		@JvmName("ltInt")
		infix fun Named.lt(value: OperationsGroup<Int>): Operation<Any> {
			return Operation(
				this,
				Comparison.LT,
				value
			) as Operation<Any>
		}

		@JvmName("gtInt")

		infix fun Named.gt(value: OperationsGroup<Int>): Operation<Any> {
			return Operation(
				this,
				Comparison.GT,
				value
			) as Operation<Any>
		}


		fun from(vararg sport: Sport): ESL2 {
			return ESL2(sport.toList())
		}


		fun <T : Any> or(vararg value: T): OperationsGroup<T> = OperationsGroup(
			GroupComparisonOperator.OR,
			value.map { Value(it) }.toList()
		)

		fun <T : Any> and(vararg value: T): OperationsGroup<T> = OperationsGroup(
			GroupComparisonOperator.AND,
			value.map { Value(it) }.toList()
		)

		fun <T : Any> only(value: T): OperationsGroup<T> = OperationsGroup(
			GroupComparisonOperator.AND,
			listOf(Value(value))
		)
	}


	@Serializable
	enum class Named {
		TEAM_HOST,
		TEAM_GUEST,
		EVENT_STATUS,
		SCORE_TEAM_HOST,
		SCORE_TEAM_GUEST,
		START_AT,
		PARENT_EVENT_ID,
		EVENT_ID,
	}

	@Serializable
	enum class Comparison {
		LT,
		GT,
		EQ,
		LIKE,
	}

	@Serializable
	enum class GroupComparisonOperator {
		AND,
		OR
	}

	@Serializable
	data class Value<T : Any>(
		val value: T
	)

	@Serializable
	class Operation<T : Any>(
		val name: Named,
		val comparison: Comparison,
		val value: OperationsGroup<T>,
		val isReversedComparison: Boolean = false,
	) {
		val hexId: String
			get() {
				val md = MessageDigest.getInstance("MD5")
				return BigInteger(1, md.digest((name.toString() + comparison.toString()).toByteArray())).toString(16).padStart(32, '0').take(6)
			}
	}

	@Serializable
	data class OperationsGroup<T : Any>(
		val groupOperation: GroupComparisonOperator,
		val values: List<Value<T>>
	)


	@Suppress("UNCHECKED_CAST")
	fun <T : Any> use(vararg operations: Operation<T>) {
		this.operations.addAll(buildList {
			operations.map {
				add(it as Operation<Any>)
			}
		}.distinctBy { it.hexId })
	}
}
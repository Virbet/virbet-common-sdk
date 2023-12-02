package org.wireforce.virbet.classes

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.math.BigInteger
import java.security.MessageDigest

@Serializable

/**
 * DSL (Domain Specific Language) для построения запросов с использованием операций,
 * связанных с видами спорта.
 *
 * @property sports Список видов спорта.
 */
class ESL2(private val sports: List<Sport>) {

	/**
	 * Список операций, выполняемых в рамках текущего запроса.
	 */
	@Serializable
	@Contextual
	private val operations: MutableList<Operation<@Contextual Any>> = mutableListOf()

	/**
	 * Получение списка операций.
	 *
	 * @return Список операций.
	 */
	@Suppress("Unused")
	fun getOperations() = operations

	/**
	 * Получение списка видов спорта, используемых в текущем запросе.
	 *
	 * @return Список видов спорта.
	 */
	@Suppress("Unused")
	fun getSportsScope() = sports

	/**
	 * Компаньон-объект, предоставляющий функции для создания и комбинирования операций.
	 */
	companion object {

		/**
		 * Расширение для создания объекта [ESL2] и выполнения над ним операций.
		 *
		 * @receiver Текущий объект [ESL2].
		 * @param init Функция-инициализатор для выполнения операций над [ESL2].
		 * @return Исходный [ESL2] после выполнения операций.
		 */
		infix fun ESL2.select(init: ESL2.() -> Unit): ESL2 {
			init()
			return this
		}

		/**
		 * Функция для создания операции отрицания.
		 *
		 * @param values Операция, которую нужно инвертировать.
		 * @return Инвертированная операция.
		 */
		fun <T: Any> not(values: Operation<T>): Operation<T> {
			return Operation(
				values.name,
				values.comparison,
				values.value,
				true
			)
		}

		// Далее идут функции для создания различных операций, таких как сравнение, проверка равенства, и т.д.

		@Suppress("Unused")
		infix fun <T: Any> Named.eq(value: OperationsGroup<T>): Operation<T> {
			return Operation(
				this,
				Comparison.EQ,
				value
			)
		}

		@Suppress("Unused")
		infix fun Named.like(value: OperationsGroup<String>): Operation<Any> {
			return Operation(
				this,
				Comparison.LIKE,
				value
			) as Operation<Any>
		}

		@Suppress("Unused")
		infix fun Named.lt(value: OperationsGroup<Double>): Operation<Any> {
			return Operation(
				this,
				Comparison.LT,
				value
			) as Operation<Any>
		}

		@Suppress("Unused")
		infix fun Named.gt(value: OperationsGroup<Double>): Operation<Any> {
			return Operation(
				this,
				Comparison.GT,
				value
			) as Operation<Any>
		}

		@Suppress("Unused")
		infix fun Named.lt(value: OperationsGroup<Int>): Operation<Any> {
			return Operation(
				this,
				Comparison.LT,
				value
			) as Operation<Any>
		}

		@Suppress("Unused")
		infix fun Named.gt(value: OperationsGroup<Int>): Operation<Any> {
			return Operation(
				this,
				Comparison.GT,
				value
			) as Operation<Any>
		}

		/**
		 * Функция для создания объекта [ESL2] с определенными видами спорта.
		 *
		 * @param sport Виды спорта, которые необходимо использовать.
		 * @return Объект [ESL2] с заданными видами спорта.
		 */
		fun from(vararg sport: Sport): ESL2 {
			return ESL2(sport.toList())
		}

		// Функции для создания групп операций (OR, AND, ONLY).

		/**
		 * Создание группы операций с оператором "ИЛИ" (OR).
		 *
		 * @param value Значения для объединения.
		 * @return Группа операций "ИЛИ" (OR).
		 */
		@Suppress("Unused")
		fun <T : Any> or(vararg value: T): OperationsGroup<T> = OperationsGroup(
			GroupComparisonOperator.OR,
			value.map { Value(it) }.toList()
		)

		/**
		 * Создание группы операций с оператором "И" (AND).
		 *
		 * @param value Значения для объединения.
		 * @return Группа операций "И" (AND).
		 */
		@Suppress("Unused")
		fun <T : Any> and(vararg value: T): OperationsGroup<T> = OperationsGroup(
			GroupComparisonOperator.AND,
			value.map { Value(it) }.toList()
		)

		/**
		 * Создание группы операций с оператором "И" (AND) для одного значения.
		 *
		 * @param value Значение для группировки.
		 * @return Группа операций "И" (AND) для одного значения.
		 */
		@Suppress("Unused")
		fun <T : Any> only(value: T): OperationsGroup<T> = OperationsGroup(
			GroupComparisonOperator.AND,
			listOf(Value(value))
		)
	}

	// Далее следуют внутренние классы и перечисления для представления операций.

	// ...

	/**
	 * Внутренний enum class для представления именованных операций.
	 */
	@Serializable
	enum class Named {
		/**
		 * Имя операции для выбора данных, связанных с хозяйствующей командой.
		 */
		TEAM_HOST,

		/**
		 * Имя операции для выбора данных, связанных с гостевой командой.
		 */
		TEAM_GUEST,

		/**
		 * Имя операции для выбора данных, связанных со статусом события.
		 */
		EVENT_STATUS,

		/**
		 * Имя операции для выбора данных, связанных с счетом хозяев.
		 */
		SCORE_TEAM_HOST,

		/**
		 * Имя операции для выбора данных, связанных с счетом гостей.
		 */
		SCORE_TEAM_GUEST,

		/**
		 * Имя операции для выбора данных, связанных с временем начала события.
		 */
		START_AT,

		/**
		 * Имя операции для выбора данных, связанных с идентификатором родительского события.
		 */
		PARENT_EVENT_ID,

		/**
		 * Имя операции для выбора данных, связанных с идентификатором события.
		 */
		EVENT_ID,
	}


	/**
	 * Внутренний enum class для представления типов сравнения.
	 */
	@Serializable
	enum class Comparison {
		LT,
		GT,
		EQ,
		LIKE,
	}

	/**
	 * Внутренний enum class для представления операторов группировки (AND, OR).
	 */
	@Serializable
	enum class GroupComparisonOperator {
		AND,
		OR
	}

	/**
	 * Внутренний data class для представления значения.
	 *
	 * @property value Значение.
	 */
	@Serializable
	data class Value<T : Any>(
		val value: T
	)

	/**
	 * Внутренний class для представления операции.
	 *
	 * @property name Имя операции.
	 * @property comparison Тип сравнения.
	 * @property value Группа операций.
	 * @property isReversedComparison Флаг инверсии операции.
	 */
	@Serializable
	class Operation<T : Any>(
		@Suppress("Unused") val name: Named,
		@Suppress("Unused") val comparison: Comparison,
		@Suppress("Unused") val value: OperationsGroup<T>,
		@Suppress("Unused") val isReversedComparison: Boolean = false,
	) {
		/**
		 * Получение уникального идентификатора в виде шестнадцатеричной строки.
		 *
		 * @return Уникальный идентификатор.
		 */
		val hexId: String
			get() {
				val md = MessageDigest.getInstance("MD5")
				return BigInteger(1, md.digest((name.toString() + comparison.toString()).toByteArray())).toString(16).padStart(32, '0').take(6)
			}
	}

	/**
	 * Внутренний data class для представления группы операций.
	 *
	 * @property groupOperation Оператор группировки (AND, OR).
	 * @property values Значения группы операций.
	 */
	@Serializable
	data class OperationsGroup<T : Any>(
		val groupOperation: GroupComparisonOperator,
		val values: List<Value<T>>
	)

	/**
	 * Функция для добавления операций в текущий объект [ESL2].
	 *
	 * @param operations Список операций для добавления.
	 */
	@Suppress("UNCHECKED_CAST")
	fun <T : Any> use(vararg operations: Operation<T>) {
		this.operations.addAll(buildList {
			operations.map {
				add(it as Operation<Any>)
			}
		}.distinctBy { it.hexId })
	}
}

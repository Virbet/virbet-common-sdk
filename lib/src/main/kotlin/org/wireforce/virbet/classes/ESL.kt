package org.wireforce.virbet.classes

import com.google.gson.reflect.TypeToken
import kotlinx.serialization.Serializable
import org.wireforce.virbet.dto.KtorEventsCursor
import org.wireforce.virbet.factory.GsonFactory

typealias ComplexOperatorValue = String


@Serializable
class ESL {
//	lateinit var sportId: Sport
//
//	private val filterMap = HashMap<FilterKey, FilterOperation<Any>>()
//
//
//	companion object {
//		class ExportedESL : TypeToken<Pair<Sport, List<FilterOperation<Any>>>>()
//
//		class OperatorOr : ComplexOperatorA<Any> {
//			override fun invoke(vararg values: FilteredOperatorValue<Any>): ComplexOperatorA<Any> {
//				return this
//			}
//		}
//
//		class OperatorAnd : ComplexOperatorA<Any> {
//			override fun invoke(vararg values: FilteredOperatorValue<Any>): ComplexOperatorA<Any> {
//				return this
//			}
//		}
//
//		interface ComplexOperatorA <T> {
//			fun invoke(vararg values: FilteredOperatorValue<T>): ComplexOperatorA<T>
//		}
//
//		data class FilteredOperatorValue<T>(
//			val value: T?
//		)
//
//		val and = OperatorAnd()
//		val or = OperatorAnd()
//
//		fun deserialize(value: String) = GsonFactory.getInstance().fromJson<Pair<Sport, List<FilterOperation<Any>>>>(value, ExportedESL().type)
//
//		@Serializable
//		enum class FilterKey {
//			HOME_TEAM_IS,
//			GUEST_TEAM_IS,
//			IS_RELEVANT,
//			SCORE,
//			SCORE_HOME_TEAM,
//			SCORE_GUEST_TEAM,
//		}
//
//
//		@Serializable
//		enum class FilterOperations {
//			EQ,
//			LIKE,
//			NE,
//		}
//
//		@Serializable
//		data class FilterOperation<T>(
//			val key: FilterKey,
//			val operation: FilterOperations,
//			val value: ComplexOperator<T>?,
//		)
//
//		fun esl(sport: Sport, init: ESL.() -> Unit): KtorEventsCursor {
//			val esl = ESL()
//			esl.init()
//			esl.sportId = sport
//			return KtorEventsCursor(esl.export())
//		}
//	}
//
//	infix fun FilterKey.eq(value: ComplexOperator<Boolean>) {
//		filterMap[this] = FilterOperation(this, FilterOperations.EQ, value as ComplexOperator<Any>)
//	}
//
//
////	infix fun FilterKey.notEq(value: KtorEventTeam?) {
////		filterMap[this] = FilterOperation(this, FilterOperations.NE, value?.toString())
////	}
////
////	infix fun FilterKey.like(value: String) {
////		filterMap[this] = FilterOperation(this, FilterOperations.LIKE, value)
////	}
////
////	infix fun FilterKey.ne(value: String?) {
////		filterMap[this] = FilterOperation(this, FilterOperations.NE, value)
////	}
//
////	infix fun FilterKey.ne(value: KtorEventTeam?) {
////		filterMap[this] = FilterOperation(this, FilterOperations.NE, value?.toString())
////	}
//
//	fun export(): Pair<Sport, List<FilterOperation<Any>>> {
//		return sportId to filterMap.toList().distinctBy { it.first }.map { it.second }
//	}
//
//	fun serialize() = GsonFactory.getInstance().toJson(export())
//
//	override fun toString() = serialize()
}
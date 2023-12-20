package org.wireforce.virbet.classes

import org.wireforce.virbet.dto.KtorEventFully
import org.wireforce.virbet.dto.KtorEventSlim
import org.wireforce.virbet.interfaces.IKtorBasicEvent

/**
 * Представляет набор констант и вспомогательные функции, связанные с факторами.
 *
 * @property WIN_HOSTS_TEAM Константа, представляющая победу хозяев.
 * @property WIN_DRAW Константа, представляющая ничью в матче.
 * @property WIN_GUESTS_TEAM Константа, представляющая победу гостей.
 * @property TOTAL_1 Константа, представляющая значение total 1.
 * @property TOTAL_2 Константа, представляющая значение total 2.
 * @property TOTAL_3 Константа, представляющая значение total 3.
 */
@Suppress("Unused")
abstract class Factor {
	companion object {
		@Deprecated("use WIN_HOSTS_TEAM")
		@Suppress("Unused") const val WIN_FIRST_TEAM = 1_001
		@Suppress("Unused") const val WIN_HOSTS_TEAM = 1_001

		@Suppress("Unused") const val WIN_DRAW = 1_002

		@Deprecated("use WIN_GUESTS_TEAM")
		@Suppress("Unused") const val WIN_SECOND_TEAM = 1_003
		@Suppress("Unused") const val WIN_GUESTS_TEAM = 1_003

		@Suppress("Unused") const val TOTAL_1 = 4_001
		@Suppress("Unused") const val TOTAL_2 = 4_002
		@Suppress("Unused") const val TOTAL_3 = 4_004

		private val totalsGroup by lazy {
			listOf(TOTAL_1, TOTAL_2, TOTAL_3)
		}

		private val winsGroup by lazy {
			listOf(WIN_HOSTS_TEAM, WIN_DRAW, WIN_GUESTS_TEAM)
		}

		/**
		 * Получает группу значений win group.
		 *
		 * @return Список значений win group.
		 */
		@Suppress("Unused")
		@JvmName("getWinsGroupKotlin")
		fun getWinsGroup() = winsGroup

		/**
		 * Получает группу значений totals group.
		 *
		 * @return Список значений totals group.
		 */
		@Suppress("Unused")
		@JvmName("getTotalsGroupKotlin")
		fun getTotalsGroup() = totalsGroup

		/**
		 * Объединяет все списки значений в один список.
		 *
		 * @return Список всех значений фабрик.
		 */
		@Suppress("Unused")
		@JvmName("getAllFactoriesKotlin")
		fun getAllFactories() =
			listOfNotNull(
				totalsGroup,
				winsGroup,
			)
			.flatten()

		/**
		 * Получает основные факторы для предпросмотра на основе экземпляра IKtorBasicEvent.
		 *
		 * @receiver Экземпляр IKtorBasicEvent.
		 * @return Карта основных факторов.
		 */
		@Suppress("Unused")
		fun IKtorBasicEvent.getPrimaryFactoriesForPreview() = hashMapOf(
			WIN_HOSTS_TEAM to factors.find { it.factorId == WIN_HOSTS_TEAM },
			WIN_DRAW to factors.find { it.factorId == WIN_DRAW },
			WIN_GUESTS_TEAM to factors.find { it.factorId == WIN_GUESTS_TEAM },
		)
	}
}

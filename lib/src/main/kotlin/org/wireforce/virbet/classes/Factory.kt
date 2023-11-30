package org.wireforce.virbet.classes

import org.wireforce.virbet.dto.KtorEventSlim

abstract class Factory {
	companion object {
		const val WIN_FIRST_TEAM = 1
		const val WIN_DRAW = -2
		const val WIN_SECOND_TEAM = 3

		const val TOTAL_1 = 4_001
		const val TOTAL_2 = 4_002
		const val TOTAL_3 = 4_004

		val totals by lazy {
			listOf(TOTAL_1, TOTAL_2, TOTAL_3)
		}

		val winsGroup by lazy {
			listOf(WIN_FIRST_TEAM, WIN_DRAW, WIN_SECOND_TEAM)
		}

		@Suppress("Unused")
		fun getAllFactory() =
			listOfNotNull(
				totals,
				winsGroup,
			)
			.flatten()

		@Suppress("Unused")
		fun KtorEventSlim.getPrimaryFactoriesForPreview() = hashMapOf(
			WIN_FIRST_TEAM to factors.find { it.factorId == WIN_FIRST_TEAM },
			WIN_DRAW to factors.find { it.factorId == WIN_DRAW },
			WIN_SECOND_TEAM to factors.find { it.factorId == WIN_SECOND_TEAM },
		)
	}
}

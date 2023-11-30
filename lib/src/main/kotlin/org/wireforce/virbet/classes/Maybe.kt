package org.wireforce.virbet.classes

import org.jetbrains.annotations.Nullable

sealed class Maybe {
	companion object {
		@Suppress("Unused")
		fun MaybeUnit.isTrue() = this == MaybeUnit.YES

		@Suppress("Unused")
		fun MaybeUnit.isFalse() = this in listOf(MaybeUnit.NO, MaybeUnit.MAYBE)

		@Suppress("Unused")
		fun MaybeUnit.asBoolean() = isTrue()

		@Suppress("Unused")
		fun of(boolean: Boolean?) = when (boolean) {
			true -> MaybeUnit.YES
			false -> MaybeUnit.NO
			null -> MaybeUnit.MAYBE
		}

		@Suppress("Unused")
		fun Boolean?.asMaybe() = of(this)
	}

	enum class MaybeUnit {
		YES,
		NO,
		MAYBE
	}
}
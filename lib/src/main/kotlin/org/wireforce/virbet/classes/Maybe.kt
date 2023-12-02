package org.wireforce.virbet.classes

import org.jetbrains.annotations.Nullable

/**
 * Представляет тип Maybe, который может принимать одно из трех значений: YES, NO или MAYBE.
 */
sealed class Maybe {
	companion object {

		/**
		 * Проверяет, является ли MaybeUnit значением YES.
		 *
		 * @return `true`, если MaybeUnit равен YES, в противном случае `false`.
		 */
		@Suppress("Unused")
		fun MaybeUnit.isTrue() = this == MaybeUnit.YES

		/**
		 * Проверяет, является ли MaybeUnit значением NO или MAYBE.
		 *
		 * @return `true`, если MaybeUnit равен NO или MAYBE, в противном случае `false`.
		 */
		@Suppress("Unused")
		fun MaybeUnit.isFalse() = this in listOf(MaybeUnit.NO, MaybeUnit.MAYBE)

		/**
		 * Возвращает значение MaybeUnit в виде логического значения.
		 *
		 * @return `true`, если MaybeUnit равен YES, в противном случае `false`.
		 */
		@Suppress("Unused")
		fun MaybeUnit.asBoolean() = isTrue()

		/**
		 * Создает объект MaybeUnit на основе логического значения.
		 *
		 * @param boolean Логическое значение.
		 * @return MaybeUnit.YES, если `boolean` равен `true`, MaybeUnit.NO, если `boolean` равен `false`,
		 * или MaybeUnit.MAYBE, если `boolean` равен `null`.
		 */
		@Suppress("Unused")
		fun of(boolean: Boolean?) = when (boolean) {
			true -> MaybeUnit.YES
			false -> MaybeUnit.NO
			null -> MaybeUnit.MAYBE
		}

		/**
		 * Преобразует логическое значение в MaybeUnit.
		 *
		 * @param boolean Логическое значение.
		 * @return MaybeUnit.YES, если `boolean` равен `true`, MaybeUnit.NO, если `boolean` равен `false`,
		 * или MaybeUnit.MAYBE, если `boolean` равен `null`.
		 */
		@Suppress("Unused")
		fun Boolean?.asMaybe() = of(this)
	}

	/**
	 * Перечисление для представления трех возможных состояний Maybe.
	 */
	enum class MaybeUnit {
		YES,
		NO,
		MAYBE
	}
}

package org.wireforce.virbet.classes

class Constants {
	companion object {
		/**
		 * Константа `RETROFIT_DEFAULT_ZIPPED_LIMIT` представляет собой значение по умолчанию для ограничения
		 * при работе с Retrofit в сжатом формате (zipped). Значение: 12.
		 */
		@Suppress("Unused")
		const val RETROFIT_DEFAULT_ZIPPED_LIMIT = 12

		/**
		 * Константа `RETROFIT_DEFAULT_LIMIT` представляет собой значение по умолчанию для общего ограничения
		 * при работе с Retrofit. Значение: 32.
		 */
		@Suppress("Unused")
		const val RETROFIT_DEFAULT_LIMIT = 32

		/**
		 * Константа `RETROFIT_DEFAULT_OFFSET` представляет собой значение по умолчанию для смещения
		 * при работе с Retrofit без сжатия. Значение: 0.
		 */
		@Suppress("Unused")
		const val RETROFIT_DEFAULT_OFFSET = 0

		/**
		 * Константа `RETROFIT_DEFAULT_ZIPPED_OFFSET` представляет собой значение по умолчанию для смещения
		 * при работе с Retrofit в сжатом формате (zipped). Значение: 0.
		 */
		@Suppress("Unused")
		const val RETROFIT_DEFAULT_ZIPPED_OFFSET = 0

	}
}
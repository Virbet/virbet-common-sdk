package org.wireforce.virbet.factory

import org.wireforce.virbet.classes.AbstractSingletonFactory
import org.wireforce.virbet.classes.LogFormatter
import org.wireforce.virbet.interfaces.ICommonSingletonFactoryStatic
import java.util.logging.ConsoleHandler
import java.util.logging.Logger

/**
 * Фабрика для создания и предоставления единственного экземпляра [Logger].
 * Использует паттерн "Одиночка" (Singleton).
 */
class LoggerFactory : AbstractSingletonFactory() {

	/**
	 * Компаньон-объект, предоставляющий статические методы для работы с фабрикой [LoggerFactory].
	 */
	companion object : ICommonSingletonFactoryStatic<Logger> {

		/**
		 * Лениво инициализированный экземпляр [ConsoleHandler] с настройками форматирования.
		 */
		private val handler by lazy {
			ConsoleHandler().apply {
				formatter = Companion.formatter
			}
		}

		/**
		 * Лениво инициализированный экземпляр [LogFormatter] для форматирования записей лога.
		 */
		private val formatter by lazy {
			LogFormatter()
		}

		/**
		 * Лениво инициализированный экземпляр [Logger] с настройками для логгера "VirbetLogger".
		 */
		private val logger: Logger by lazy {
			Logger.getLogger("VirbetLogger").apply {
				useParentHandlers = false
				addHandler(handler)
			}
		}

		/**
		 * Получение единственного экземпляра [Logger].
		 *
		 * @return Единственный экземпляр [Logger].
		 */
		override fun getInstance(): Logger {
			System.setProperty("java.util.logging.SimpleFormatter.format", "%1\$tF %1\$tT %4\$s %2\$s %5\$s%6\$s%n")

			return logger
		}
	}
}
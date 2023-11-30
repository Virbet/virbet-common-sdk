package org.wireforce.virbet.factory

import org.wireforce.virbet.classes.AbstractSingletonFactory
import org.wireforce.virbet.classes.LogFormatter
import org.wireforce.virbet.interfaces.ICommonSingletonFactoryStatic
import java.util.logging.ConsoleHandler
import java.util.logging.Logger

class LoggerFactory : AbstractSingletonFactory() {
	companion object : ICommonSingletonFactoryStatic<Logger> {
		private val handler by lazy {
			ConsoleHandler().apply {
				formatter = Companion.formatter
			}
		}

		private val formatter by lazy {
			LogFormatter()
		}

		private val logger: Logger by lazy {
			Logger.getLogger("VirbetLogger").apply {
				useParentHandlers = false
				addHandler(handler)
			}
		}

		override fun getInstance(): Logger {
			System.setProperty("java.util.logging.SimpleFormatter.format", "%1\$tF %1\$tT %4\$s %2\$s %5\$s%6\$s%n")

			return logger
		}
	}

}
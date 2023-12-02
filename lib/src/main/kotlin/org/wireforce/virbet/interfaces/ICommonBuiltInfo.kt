package org.wireforce.virbet.interfaces

import java.util.Date

/**
 * Интерфейс, предоставляющий информацию о сборке SDK.
 */
interface ICommonBuiltInfo {

	/**
	 * Версия SDK.
	 */
	val version: Double

	/**
	 * Текстовая версия SDK.
	 */
	val versionText: String

	/**
	 * Время сборки SDK.
	 */
	val builtTime: Date
}

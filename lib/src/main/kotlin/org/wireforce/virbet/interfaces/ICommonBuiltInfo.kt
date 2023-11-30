package org.wireforce.virbet.interfaces

import java.util.Date

interface ICommonBuiltInfo {
	val version: Double
	val versionText: String
	val builtTime: Date
}
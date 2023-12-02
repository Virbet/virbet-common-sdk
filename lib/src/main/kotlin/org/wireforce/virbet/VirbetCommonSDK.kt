package org.wireforce.virbet

import org.wireforce.virbet.factory.LoggerFactory
import org.wireforce.virbet.factory.RetrofitFactory
import org.wireforce.virbet.interfaces.ICommonBuiltInfo
import java.net.URL
import java.util.*

@Suppress("Unused")
class VirbetCommonSDK {
	companion object : ICommonBuiltInfo {
		init {
			if (Built.IS_SNAPSHOT) {
				LoggerFactory.getInstance().warning("ATTENTION!! You are using a non-stable SDK build")
			}
		}

		override val version: Double = Built.VERSION_NUMBER
		override val versionText: String = Built.VERSION_TEXT
		override val builtTime: Date = Calendar.getInstance().apply { set( 2023, 12, 28) }.time
	}

	fun getRetrofitService(url: URL) = RetrofitFactory.getInstance(url).service

	fun getRetrofitInstance(url: URL) = RetrofitFactory.getInstance(url).instance
}
package org.wireforce.virbet

import org.wireforce.virbet.factory.RetrofitFactory
import org.wireforce.virbet.interfaces.ICommonBuiltInfo
import java.net.URL
import java.util.*

@Suppress("Unused")
class VirbetCommonSDK {
	companion object : ICommonBuiltInfo {
		override val version: Double = 0.1
		override val versionText: String = "Moth 0.0.1"
		override val builtTime: Date = Calendar.getInstance().apply { set( 2023, 12, 28) }.time
	}

	fun getRetrofitService(url: URL) = RetrofitFactory.getInstance(url).service

	fun getRetrofitInstance(url: URL) = RetrofitFactory.getInstance(url).instance
}
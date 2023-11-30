package org.wireforce.virbet.factory

import com.google.gson.*
import kotlinx.datetime.Instant
import org.wireforce.virbet.classes.AbstractSingletonFactory
import org.wireforce.virbet.interfaces.ICommonSingletonFactoryStatic

class GsonFactory : AbstractSingletonFactory() {
	companion object : ICommonSingletonFactoryStatic<Gson> {
		private val gson by lazy {
			GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(
					Instant::class.java,
					JsonDeserializer<Any?> { json, type, jsonDeserializationContext ->
						Instant.parse(json.asJsonPrimitive.asString)
					}
				)
				.registerTypeAdapter(
					Instant::class.java,
					JsonSerializer<Instant?> { json, type, jsonDeserializationContext ->
						JsonPrimitive(json.toString())
					}
				)
				.create()
		}

		override fun getInstance(): Gson = gson
	}
}
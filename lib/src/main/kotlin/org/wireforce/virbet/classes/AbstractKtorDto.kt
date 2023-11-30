package org.wireforce.virbet.classes

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto.Companion.getSchema
import org.wireforce.virbet.factory.GsonFactory

@Serializable
abstract class AbstractKtorDto {
	companion object {
		@Suppress("Unused")
		fun AbstractKtorDto.toPrettyJson() = GsonFactory.getInstance().toJson(this)

		fun AbstractKtorDto.getSchema() = buildMap {
			this@getSchema::class.java.declaredFields.map {
				if (it.name !in listOf("Companion")) {
					put(it.name, it.type.simpleName)
				}
			}
		}
	}
}
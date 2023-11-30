package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.interfaces.IKtorRequestLinkWithIDKey

@Serializable
@Suppress("Unused")
data class KtorObtainMe(
	val login: String? = null,
	val firstName: String? = null,
	val lastName: String? = null,
	val phone: String? = null,
) : AbstractKtorDto()
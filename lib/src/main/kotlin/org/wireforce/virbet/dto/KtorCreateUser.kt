package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.interfaces.IKtorRequestLinkWithIDKey

@Serializable
@Suppress("Unused")
data class KtorCreateUser(
	val login: String,
	val password: String,
	val email: String?,

	override val idKey: String,
) : AbstractKtorDto(), IKtorRequestLinkWithIDKey
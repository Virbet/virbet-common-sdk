package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.interfaces.IKtorAuthorizationResult

@Serializable
@Suppress("Unused")
data class KtorLoginInUser(
	override val jwtToken: String,
	override val idKey: String,
) : AbstractKtorDto(), IKtorAuthorizationResult
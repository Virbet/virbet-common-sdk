package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.interfaces.IKtorRequestLinkWithIDKey

@Serializable
@Suppress("Unused")
data class KtorEventTeam(
	val name: String,
	val internalId: String,
	val logotypeHttpUrl: String,
) : AbstractKtorDto()
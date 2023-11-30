package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.interfaces.IKtorRequestLinkWithIDKey

@Serializable
@Suppress("Unused")
data class KtorEventScore(
	val teamGuest: Int,
	val teamHost: Int,
) : AbstractKtorDto()
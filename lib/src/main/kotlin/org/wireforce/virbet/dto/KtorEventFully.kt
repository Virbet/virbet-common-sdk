package org.wireforce.virbet.dto

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.classes.AbstractKtorEventDto
import org.wireforce.virbet.classes.Sport
import org.wireforce.virbet.interfaces.IKtorBasicEvent
import org.wireforce.virbet.interfaces.IKtorRequestLinkWithIDKey

@Serializable
@Suppress("Unused")
data class KtorEventFully(
	override val status: KtorEventStatus,
	override val eventName: String? = null,
	override val teamGuest: KtorEventTeam,
	override val teamHost: KtorEventTeam,
	override val score: KtorEventScore? = null,
	override val startAt: Instant? = null,
	override val factors: List<KtorEventFactor> = listOf(),
	override val eventId: String,
	override val sportId: Sport,
) : AbstractKtorEventDto(), IKtorBasicEvent
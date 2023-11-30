package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable

@Serializable
enum class KtorEventStatus {
	FUTURE,
	LIVE,
	FINISHED,
}
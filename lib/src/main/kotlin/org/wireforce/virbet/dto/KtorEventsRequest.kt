package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.classes.AbstractKtorEventDto

@Serializable
@Suppress("Unused")
data class KtorEventsRequest<T : AbstractKtorEventDto>(
	val executedTime: Double? = null,
	val events: List<T>,
	val sliceSize: Int,
	val limit: Int,
	val offset: Int,
	val canNext: Boolean,
	val nextOffset: Int? = null,
) : AbstractKtorDto()
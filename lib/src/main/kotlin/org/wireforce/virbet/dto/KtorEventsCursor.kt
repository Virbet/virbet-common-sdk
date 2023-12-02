package org.wireforce.virbet.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.classes.ESL2

@Serializable
@Suppress("Unused")
data class KtorEventsCursor(
	@Contextual
	@Serializable
	val cursor: ESL2
) : AbstractKtorDto()
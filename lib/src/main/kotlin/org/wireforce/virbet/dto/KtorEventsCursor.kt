package org.wireforce.virbet.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.classes.ESL
import org.wireforce.virbet.classes.ESL2
import org.wireforce.virbet.classes.Sport

@Serializable
@Suppress("Unused")
data class KtorEventsCursor(
	@Contextual
	@Serializable
	val cursor: ESL2
) : AbstractKtorDto()
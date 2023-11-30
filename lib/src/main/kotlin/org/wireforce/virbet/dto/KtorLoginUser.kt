package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto

@Serializable
@Suppress("Unused")
data class KtorLoginUser(
	val loginOrEmail: String,
	val password: String,
) : AbstractKtorDto()
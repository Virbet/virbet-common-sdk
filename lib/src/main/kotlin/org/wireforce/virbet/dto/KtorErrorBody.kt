package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto

@Serializable
@Suppress("Unused")
data class KtorErrorBody(
	val errorMessage: String,
	val externalError: Int,
	val howToFix: String? = null,
) : AbstractKtorDto()
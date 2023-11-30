package org.wireforce.virbet.dto

import io.ktor.http.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto

@Serializable
@Suppress("Unused")
data class KtorResponseError(
	val data: KtorErrorBody? = null,
	@Contextual val status: HttpStatusCode = HttpStatusCode.OK,
) : AbstractKtorDto()
package org.wireforce.virbet.dto

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto

/**
 * Data class `KtorResponse` представляет собой ответ от сервера в системе Ktor.
 *
 * @param data Объект типа `A`, представляющий данные ответа.
 * @param status Объект типа `HttpStatusCode`, представляющий статус ответа (по умолчанию `HttpStatusCode.OK`).
 */
@Serializable
@Suppress("Unused")
data class KtorResponse<A : AbstractKtorDto>(
	val data: A? = null,
	@Contextual val status: HttpStatusCode = HttpStatusCode.OK,
) : AbstractKtorDto()
package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.interfaces.IKtorAuthorizationResult

/**
 * Data class `KtorIdKeyRelease` представляет собой результат выпуска IDKey в системе.
 *
 * @param youTriedRequestAccounts Количество попыток запроса учетных записей.
 * @param requireSignup Флаг, указывающий, требуется ли регистрация (по умолчанию `false`).
 * @param jwtToken Строка, содержащая JWT-токен.
 * @param idKey Строка, представляющая выданный ключ ID.
 */
@Serializable
@Suppress("Unused")
data class KtorIdKeyRelease(
	val youTriedRequestAccounts: Int? = null,
	val requireSignup: Boolean = false,

	override val jwtToken: String,
	override val idKey: String,
) : AbstractKtorDto(), IKtorAuthorizationResult
package org.wireforce.virbet.dto

import kotlinx.serialization.Serializable
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.interfaces.IKtorAuthorizationResult

@Serializable
@Suppress("Unused")
data class KtorCreatedBalance(
	val obtainBalance: KtorObtainBalance,
	val isCreated: Boolean
) : AbstractKtorDto()
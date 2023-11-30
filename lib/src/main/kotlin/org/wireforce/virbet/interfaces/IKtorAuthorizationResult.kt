package org.wireforce.virbet.interfaces

/**
 * Интерфейс `IKtorAuthorizationResult` предоставляет контракт для классов,
 * представляющих результат авторизации.
 */
interface IKtorAuthorizationResult {
	val jwtToken: String
	val idKey: String
}
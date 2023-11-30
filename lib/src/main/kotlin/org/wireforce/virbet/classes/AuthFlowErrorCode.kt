package org.wireforce.virbet.classes

/**
 * Enum `AuthFlowErrorCode` представляет собой перечень возможных кодов ошибок в рамках авторизационного процесса.
 */
@Suppress("unused")
enum class AuthFlowErrorCode(val code: Int) {
	/**
	 * Система отклонила запрос. Политика по борьбе с мошенничеством. Код ошибки: 100.
	 */
	@Suppress("unused")
	FROUND_SYSTEM_DECLINE_REQUEST(100),

	/**
	 * Логин уже существует. Код ошибки: 401.
	 */
	@Suppress("unused")
	LOGIN_READY_EXISTS(401),

	/**
	 * Некорректный логин. Код ошибки: 402.
	 */
	@Suppress("unused")
	LOGIN_INCORRECT(402),

	/**
	 * Логин не на английском. Код ошибки: 403.
	 */
	@Suppress("unused")
	LOGIN_NOT_ENGLISH(403),

	/**
	 * Слишком слабый пароль. Код ошибки: 501.
	 */
	@Suppress("unused")
	PASSWORD_TOO_WEAK(501)
}

package org.wireforce.virbet.classes

import org.wireforce.virbet.classes.Maybe.Companion.asMaybe
import org.wireforce.virbet.classes.Maybe.Companion.isTrue
import java.security.cert.CertificateExpiredException
import java.time.Instant

class JWT {
	companion object {
		const val jwtAudience = "virbet-audience"
		const val jwtDomain = "https://virbet.io"
		const val jwtRealm = "Virbet Common SDK"

		/**
		 * Расширение для строки, добавляющее префикс "Bearer ".
		 * Используется для формирования формата Bearer-токена.
		 *
		 * @receiver Строка, которую необходимо преобразовать в Bearer-токен.
		 * @return Строка Bearer-токена.
		 */
		@Suppress("Unused")
		fun String.toBearer() = "Bearer ${this.trim()}"

		/**
		 * Функция `wrapJwtCleanToBearerToken` оборачивает переданный JWT-токен в формат Bearer-токена.
		 * Добавляет префикс "Bearer " к указанному токену.
		 *
		 * @param token Строка, представляющая JWT-токен.
		 * @return Строка Bearer-токена.
		 */
		@Suppress("Unused")
		fun wrapJwtCleanToBearerToken(token: String) = token.toBearer()

		/**
		 * Функция `isValidAndroidJwtToken` используется для проверки валидности Android JWT-токена.
		 *
		 * @param token Строка, представляющая JWT-токен для проверки.
		 * @param ignoreExpiredException Флаг, указывающий, следует ли игнорировать исключение по истечении срока действия токена.
		 *                              По умолчанию установлен в `false`.
		 * @return `true`, если токен валиден; в противном случае - `false`.
		 */
		fun isValidAndroidJwtToken(token: String, ignoreExpiredException: Boolean = false): Boolean {
			val auth0jwt = com.auth0.jwt.JWT()
			val jwtDecoded = try {
				auth0jwt.decodeJwt(token)
			} catch (e: com.auth0.jwt.exceptions.JWTDecodeException) {
				null
			}

			val validation = hashMapOf(
				"jwtAudience" to (jwtDecoded?.audience?.first() == jwtAudience),
				"jwtDomain" to (jwtDecoded?.issuer == jwtDomain),
				"expiresAt" to (ignoreExpiredException || (jwtDecoded?.expiresAtAsInstant != null && jwtDecoded.expiresAtAsInstant > Instant.now())),
			)

			return validation.all { it.value }
		}

		/**
		 * Функция `isJwtExpired` проверяет, истек ли срок действия JWT-токена.
		 *
		 * Ответ Maybe предполагает, что вы передали невалидный токен или система по тем или иным причинам не понимает, истек ли он или нет в точности.
		 *
		 * @param token Строка, представляющая JWT-токен.
		 * @return Объект типа `Maybe.MaybeUnit`.
		 */
		fun isJwtExpired(token: String): Maybe.MaybeUnit {
			val auth0jwt = com.auth0.jwt.JWT()

			val jwtDecoded = try {
				auth0jwt.decodeJwt(token)
			} catch (e: com.auth0.jwt.exceptions.JWTDecodeException) {
				null
			}

			return (!(jwtDecoded?.expiresAtAsInstant != null && jwtDecoded.expiresAtAsInstant > Instant.now())).asMaybe()
		}

		/**
		 * Функция `isNeedUpdateJwt` определяет, нужно ли обновлять JWT-токен на основе проверки истечения его срока действия.
		 *
		 * @param token Строка, представляющая JWT-токен.
		 * @return Результат проверки: `true`, если токен истек, иначе `false`.
		 */
		fun isNeedUpdateJwt(token: String) = isJwtExpired(token).isTrue()
	}
}
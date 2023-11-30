package org.wireforce.virbet.retrofit

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import org.jetbrains.annotations.NotNull
import org.wireforce.virbet.classes.Constants
import org.wireforce.virbet.classes.ContentLanguage
import org.wireforce.virbet.classes.Sport
import org.wireforce.virbet.dto.*
import retrofit2.Call
import retrofit2.http.*


/**
 * Интерфейс `RetrofitInterfaceMain` содержит объявления методов для взаимодействия с удаленным сервером
 * посредством библиотеки Retrofit в контексте основных операций приложения.
 *
 */
interface RetrofitInterfaceMain {
	/**
	 * Метод `generateAnonymousIDKey` выполняет GET-запрос для получения ID ключа.
	 * Данный ID ключ служит для представления пользователя без логина и пароля,
	 * обеспечивая анонимный вход в систему.
	 *
	 * @param requestId Строка, представляющая идентификатор запроса (по умолчанию генерируется случайным образом).
	 *                  Служит для предотвращения безконтрольного выпуска ключей.
	 *                  По умолчанию пользователь может выпустить 3 ID ключа на один IP-адрес в целях безопасности,
	 *                  но существует вероятность холостого выпуска ключей. Чтобы предотвратить такой выпуск, используйте requestId.
	 *                  ВНИМАНИЕ! requestId кешируется на 24 секунды с момента первого запроса
	 *
	 * @return Объект типа `Call<KtorResponse<KtorIdKeyRelease>>`, представляющий асинхронный результат запроса.
	 * @since 1
	 * @see login
	 *
	 * Примеры использования:
	 * - requestIdKey() // Возвращает ID ключа, например, "JHGKHJDGKJHG"
	 * - requestIdKey() // Возвращает новый ID ключа, например, "VLGKAJHGKJDD"
	 * - requestIdKey("AnyString") // Возвращает ID ключа, например, "JHGKHJDGKJHG"
	 * - requestIdKey("AnyString") // Возвращает тот же ID ключа, что и предыдущий вызов, так как использован requestId
	 */
	@GET("/auth/requestIdKey")
	@Suppress("Unused")
	fun generateAnonymousIDKey(
		@Query("requestId") requestId: String = NanoIdUtils.randomNanoId()
	): Call<KtorResponse<KtorIdKeyRelease>>

	/**
	 * Метод `login` выполняет POST-запрос для входа в систему через ключ ID.
	 *
	 * @since 1
	 * @see generateAnonymousIDKey
	 * @param idKey Строка, представляющая тело запроса.
	 * @return Объект типа `Call<KtorResponse<KtorLoginInUser>>`, представляющий асинхронный результат запроса.
	 */
	@POST("/auth/internal/loginThoughIDKey")
	@Suppress("Unused")
	fun login(@Body idKey: KtorAuthThoughIdKey): Call<KtorResponse<KtorLoginInUser>>

	/**
	 * Метод `login` выполняет POST-запрос для входа пользователя.
	 *
	 * @param body Объект типа `KtorLoginUser`, содержащий данные для входа.
	 */
	@POST("/auth/internal/login")
	@Suppress("Unused")
	fun login(@Body body: KtorLoginUser): Call<KtorResponse<KtorLoginInUser>>

	/**
	 * Метод `signup` выполняет POST-запрос для регистрации нового пользователя.
	 *
	 * @param body Объект типа `KtorCreateUser`, содержащий данные для регистрации пользователя.
	 * @return Объект типа `Call<KtorResponse<KtorCreatedUser>>`, представляющий асинхронный результат запроса.
	 */
	@POST("/auth/internal/signup")
	@Suppress("Unused")
	fun signup(@Body body: KtorCreateUser): Call<KtorResponse<KtorCreatedUser>>

	/**
	 * Метод `getMe` выполняет GET-запрос для получения информации о текущем пользователе.
	 *
	 * @param jwtBearerToken Строка, содержащая JWT-токен, используемый для аутентификации.
	 * @return Объект типа `Call<KtorResponse<KtorObtainMe>>`, представляющий асинхронный результат запроса.
	 */
	@GET("/account/me")
	@Suppress("Unused")
	@Headers("Content-Type: application/json;charset=UTF-8")
	fun getMe(@Header("Authorization") jwtBearerToken: String): Call<KtorResponse<KtorObtainMe>>

	@GET("/wallet/balance")
	@Suppress("Unused")
	@Headers("Content-Type: application/json;charset=UTF-8")
	fun getBalance(@Header("Authorization") jwtBearerToken: String): Call<KtorResponse<KtorObtainBalance>>

	@POST("/wallet/createBalance")
	@Suppress("Unused")
	@Headers("Content-Type: application/json;charset=UTF-8")
	fun createBalanceIfNotExists(@Header("Authorization") jwtBearerToken: String): Call<KtorResponse<KtorCreatedBalance>>

	@GET("/wallet/balanceGetOrCreate")
	@Suppress("Unused")
	@Headers("Content-Type: application/json;charset=UTF-8")
	fun getBalanceOrCreate(@Header("Authorization") jwtBearerToken: String): Call<KtorResponse<KtorCreatedBalance>>

	/**
	 * Метод `getRelevantEvents` выполняет GET-запрос для получения актуальных событий.
	 *
	 * @param jwtBearerToken Строка, содержащая JWT-токен, используемый для аутентификации.
	 * @param requiredContentLanguage Язык контента (на каком языке должен быть контент с событиями) типа `ContentLanguage` (по умолчанию `ContentLanguage.EN`).
	 *
	 * @param sportId Идентификатор вида спорта типа `Sport`. Аннотация `@NotNull` указывает, что параметр не может быть `null`.
	 * @param limit Максимальное количество событий (по умолчанию значение из Constants.RETROFIT_DEFAULT_ZIPPED_LIMIT).
	 * @param offset Смещение (по умолчанию значение из Constants.RETROFIT_DEFAULT_ZIPPED_OFFSET).
	 * @return Объект типа `Call<KtorResponse<KtorEventsRequest<KtorParentEventPreview>>>`, представляющий асинхронный результат запроса.
	 */
	@GET("/events/relevant")
	@Suppress("Unused")
	@Headers("Content-Type: application/json;charset=UTF-8")
	fun getRelevantEvents(
		@Header("Authorization") jwtBearerToken: String,
		@Header("Content-Language") requiredContentLanguage: ContentLanguage = ContentLanguage.EN,
		@Query("sportId") @NotNull sportId: Sport,
		@Query("limit") limit: Int = Constants.RETROFIT_DEFAULT_ZIPPED_LIMIT,
		@Query("offset") offset: Int = Constants.RETROFIT_DEFAULT_ZIPPED_OFFSET,
	): Call<KtorResponse<KtorEventsRequest<KtorEventSlim>>>
}
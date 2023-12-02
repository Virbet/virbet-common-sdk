package org.wireforce.virbet.factory

import io.ktor.http.*
import org.wireforce.virbet.Built
import org.wireforce.virbet.classes.AbstractKtorDto
import org.wireforce.virbet.classes.AbstractKtorDto.Companion.toPrettyJson
import org.wireforce.virbet.classes.AbstractSingletonFactory
import org.wireforce.virbet.dto.KtorErrorBody
import org.wireforce.virbet.dto.KtorResponse
import org.wireforce.virbet.dto.KtorResponseError
import org.wireforce.virbet.factory.RetrofitFactory.Companion.CallResults
import org.wireforce.virbet.interfaces.ICommonSingletonFactoryStatic
import org.wireforce.virbet.retrofit.RetrofitInterfaceMain
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL
import kotlin.concurrent.thread
import kotlin.time.DurationUnit
import kotlin.time.measureTime

/**
 * Класс `RetrofitFactory` представляет собой фабрику для создания экземпляра Retrofit и соответствующего сервиса.
 */
class RetrofitFactory : AbstractSingletonFactory() {
	companion object :
		ICommonSingletonFactoryStatic<Companion.RetrofitFactoryResult> {
		private var callCount = 0
		private var instance: Retrofit? = null
		private var service: RetrofitInterfaceMain? = null

		private var defaultDebugUrl = "http://localhost:8080"

		const val DEBUG_HOST = "http://localhost:8080"

		private fun <T:AbstractKtorDto> getDefaultHandlerCaller() = CallResults<T> { result ->
			LoggerFactory.getInstance().apply {
				info("[F:RequestApiResult] **")
				info("[F:RequestApiResult] OK=${result.isOk};")
				info("[F:RequestApiResult] STATUS_CODE=${result.httpStatusCode}")
				info("[F:RequestApiResult] ERROR_THROWABLE=${result.throwableIfErrored?.localizedMessage}")
				info("[F:RequestApiResult] RESULTS (see bellow):")
				info("[F:RequestApiResult] (isNull=${result.results == null});")
				info("[F:RequestApiResult] ${result.results?.toPrettyJson()}")
			}
		}

		/**
		 * @param isOk Флаг, указывающий, успешен ли вызов.
		 * @param httpStatusCode Объект типа `HttpStatusCode` с HTTP-кодом ответа.
		 * @param results Результат вызова API типа `T`.
		 * @param throwableIfErrored Объект типа `Throwable` в случае ошибки.
		 */
		data class RequestApiResult<T: AbstractKtorDto>(
			val isOk: Boolean,
			val httpStatusCode: HttpStatusCode?,
			val results: T?,
			val throwableIfErrored: Throwable?
		)

		/**
		 * Функциональный интерфейс `CallResults` представляет собой результат вызова API с обработкой результата.
		 */
		fun interface CallResults<T : AbstractKtorDto> {
			/**
			 * Метод `invoke` вызывается при завершении вызова API.
			 */
			fun invoke(
				result: RequestApiResult<T>
			): Unit
		}

		/**
		 * Расширение для типа `Call<KtorResponse<T>>` для выполнения вызова API в фоновом режиме с обработкой результата.
		 *
		 * @param onSuccess Объект типа `CallResults<T>`, вызываемый при успешном выполнении вызова.
		 * @param onError Объект типа `CallResults<KtorErrorBody>`, вызываемый в случае ошибки.
		 */
		fun <T : AbstractKtorDto> Call<KtorResponse<T>>.callInBackground(
			onSuccess: CallResults<T> = getDefaultHandlerCaller(),
			onError: CallResults<KtorErrorBody> = getDefaultHandlerCaller(),
		) {
			thread {
				callInForeground(onSuccess, onError)
			}.apply {
				name = "CallRequest-$callCount"
			}
		}

		fun <T : AbstractKtorDto> Call<KtorResponse<T>>.callInForeground(
			onSuccess: CallResults<T> = getDefaultHandlerCaller(),
			onError: CallResults<KtorErrorBody> = getDefaultHandlerCaller(),
		) {
			callCount++

			val response = execute()

			val requestTime = measureTime {
				if (response.isSuccessful) {
					if (response.body()?.v != Built.HTTP_VERSION_TEXT) {
						LoggerFactory.getInstance().warning("[F:RequestApiResult] ATTENTION!! Warning about possible incompatibility.")
						LoggerFactory.getInstance().warning("[F:RequestApiResult] Your version of SDK=${Built.HTTP_VERSION_TEXT}")
						LoggerFactory.getInstance().warning("[F:RequestApiResult] Actual version SDK=${response.body()?.v}")
					}

					onSuccess.invoke(
						RequestApiResult(
							response.isSuccessful,
							HttpStatusCode.fromValue(response.code()),
							response.body()?.data,
							null
						)
					)

				} else {
					val errorData = response.errorBody()?.string()

					if (!errorData.isNullOrEmpty() && errorData.isNotBlank()) {
						val out = try {
							GsonFactory.getInstance().fromJson(errorData, KtorResponseError::class.java)
						} catch(e: Throwable) {
							e.printStackTrace()
							null
						}

						return onError.invoke(
							RequestApiResult(
								false,
								HttpStatusCode.fromValue(response.code()),
								out?.data,
								null
							)
						)
					}

					onError.invoke(
						RequestApiResult(
							false,
							HttpStatusCode.fromValue(response.code()),
							null,
							null
						)
					)
				}
			}

			if (Built.IS_SNAPSHOT) {
				LoggerFactory.getInstance().info("[NetStat] Call (method:${this.request().method()}) '${this.request().url()}' for ${requestTime.toDouble(DurationUnit.SECONDS)} seconds")
			}
		}



		/**
		 * Data class `RetrofitFactoryResult` представляет результат создания экземпляра Retrofit и сервиса.
		 *
		 * @property instance Экземпляр Retrofit.
		 * @property service Сервис RetrofitInterfaceMain.
		 */
		data class RetrofitFactoryResult(
			val instance: Retrofit,
			val service: RetrofitInterfaceMain
		)

		/**
		 * Получение экземпляра Retrofit и сервиса на основе базового URL.
		 *
		 * @param useBaseUrl Строка, представляющая базовый URL.
		 * @return Объект типа `RetrofitFactoryResult` с экземпляром Retrofit и сервисом.
		 */
		@Suppress("Unused")
		public fun getInstance(useBaseUrl: String) = Companion.getInstance(URL(useBaseUrl))

		/**
		 * Получение экземпляра Retrofit и сервиса на основе объекта URL.
		 *
		 * @param useBaseUrl Объект типа URL, представляющий базовый URL.
		 * @return Объект типа `RetrofitFactoryResult` с экземпляром Retrofit и сервисом.
		 */
		@Suppress("Unused")
		public fun getInstance(useBaseUrl: URL): RetrofitFactoryResult {
			if (instance == null || service == null) {
				instance = Retrofit.Builder()
					.addConverterFactory(GsonConverterFactory.create(GsonFactory.getInstance()))
					.baseUrl(useBaseUrl)
					.build()

				service = instance!!
					.create(RetrofitInterfaceMain::class.java)
			}

			return RetrofitFactoryResult(
				requireNotNull(instance),
				requireNotNull(service)
			)
		}

		@Suppress("Unused")
		fun getServiceInstance(useBaseUrl: URL) = getInstance(useBaseUrl).service

		@Suppress("Unused")
		fun getServiceInstance(useBaseUrl: String) = getInstance(useBaseUrl).service

		@Deprecated("Use getInstance(url: String) instead.", ReplaceWith("RetrofitFactory.getInstance(URL(\"https://\"))", "java.net.URL"))
		override fun getInstance(): RetrofitFactoryResult = getInstance(defaultDebugUrl)
	}
}

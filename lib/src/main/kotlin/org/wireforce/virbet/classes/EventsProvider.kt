package org.wireforce.virbet.classes

import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody
import org.wireforce.virbet.dto.KtorEventFully
import org.wireforce.virbet.dto.KtorEventsCursor
import org.wireforce.virbet.dto.KtorEventsRequest
import org.wireforce.virbet.dto.KtorResponse
import org.wireforce.virbet.factory.GsonFactory
import org.wireforce.virbet.factory.OkHttpFactory
import java.net.URL

typealias NestedEventsResults = KtorResponse<KtorEventsRequest<KtorEventFully>>

/**
 * Класс, предоставляющий методы для выполнения асинхронных запросов к серверу событий.
 *
 * @property host URL-адрес сервера событий.
 * 								Учтите, что сервер событий отличается от сервера API
 */
class EventsProvider(private val host: URL) {

	/**
	 * Внутренний класс для представления типа ответа событий.
	 */
	class EventsResponse : TypeToken<NestedEventsResults>()

	/**
	 * Выполняет асинхронный запрос к серверу для выборки событий
	 *
	 * @param query Объект, представляющий параметры запроса.
	 * @param requiredContentLanguage Язык контента, требуемый в ответе (по умолчанию - EN).
	 * @param limit Максимальное количество результатов запроса (по умолчанию - [Constants.RETROFIT_DEFAULT_LIMIT]).
	 * @param offset Смещение для запроса пагинации (по умолчанию - [Constants.RETROFIT_DEFAULT_OFFSET]).
	 * @return Результаты запроса в виде [NestedEventsResults] или null в случае ошибки.
	 */
	suspend fun queryCall(query: ESL2, requiredContentLanguage: ContentLanguage = ContentLanguage.EN, limit: Int = Constants.RETROFIT_DEFAULT_LIMIT, offset: Int = Constants.RETROFIT_DEFAULT_OFFSET): NestedEventsResults? {
		val client = OkHttpFactory.getInstance()

		val queryString = GsonFactory
			.getInstance()
			.toJson(KtorEventsCursor(query))

		val requestBody =  RequestBody.create(MediaType.parse("application/json"), queryString)

		val request: Request = Request.Builder()
			.url(URL("$host/query?limit=$limit&offset=$offset"))
			.header("Content-Language", requiredContentLanguage.code)
			.post(requestBody)
			.build()


		return coroutineScope {
			return@coroutineScope async {
				val results = client.newCall(request).execute()

				if (results.isSuccessful) {
					return@async try {
						GsonFactory.getInstance().fromJson<NestedEventsResults>(results.body()?.string(), EventsResponse().type)
					} catch (e: JsonSyntaxException) {
						e.printStackTrace()
						null
					}
				} else {
					return@async null
				}
			}.await()
		}
	}
}
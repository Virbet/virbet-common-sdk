package org.wireforce.virbet.factory

import com.google.gson.*
import kotlinx.datetime.Instant
import org.wireforce.virbet.classes.AbstractSingletonFactory
import org.wireforce.virbet.jvm.interfaces.ICommonSingletonFactoryStatic

/**
 * Фабрика для создания и предоставления единственного экземпляра [Gson].
 * Использует паттерн "Одиночка" (Singleton).
 */
@Suppress("UNUSED_ANONYMOUS_PARAMETER")
class GsonFactory : AbstractSingletonFactory() {

	/**
	 * Компаньон-объект, предоставляющий статические методы для работы с фабрикой [GsonFactory].
	 */
	companion object : ICommonSingletonFactoryStatic<Gson> {

		/**
		 * Лениво инициализированный экземпляр [Gson] с настройками, включающими красивый вывод (pretty-printing)
		 * и регистрацию адаптеров для сериализации и десериализации типа [Instant].
		 */
		private val gson by lazy {
			GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(
					Instant::class.java,
					JsonDeserializer<Any?> { json, type, jsonDeserializationContext ->
						Instant.parse(json.asJsonPrimitive.asString)
					}
				)
				.registerTypeAdapter(
					Instant::class.java,
					JsonSerializer<Instant?> { json, type, jsonDeserializationContext ->
						JsonPrimitive(json.toString())
					}
				)
				.create()
		}

		/**
		 * Получение единственного экземпляра [Gson].
		 *
		 * @return Единственный экземпляр [Gson].
		 */
		override fun getInstance(): Gson = gson
	}
}

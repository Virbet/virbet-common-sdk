package org.wireforce.virbet.factory

import okhttp3.OkHttpClient
import org.wireforce.virbet.classes.AbstractSingletonFactory
import org.wireforce.virbet.jvm.interfaces.ICommonSingletonFactoryStatic

/**
 * Фабрика для создания и предоставления единственного экземпляра [OkHttpClient].
 * Использует паттерн "Одиночка" (Singleton).
 */
class OkHttpFactory : AbstractSingletonFactory() {

	/**
	 * Компаньон-объект, предоставляющий статические методы для работы с фабрикой [OkHttpFactory].
	 */
	companion object :
		ICommonSingletonFactoryStatic<OkHttpClient> {

		/**
		 * Лениво инициализированный экземпляр [OkHttpClient] с настройками по умолчанию.
		 */
		private val okhttp by lazy {
			OkHttpClient.Builder().build()
		}

		/**
		 * Получение единственного экземпляра [OkHttpClient].
		 *
		 * @return Единственный экземпляр [OkHttpClient].
		 */
		override fun getInstance(): OkHttpClient = okhttp
	}
}

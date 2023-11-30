import Factory.Companion.getPrimaryFactoriesForPreview
import org.wireforce.virbet.classes.ContentLanguage
import org.wireforce.virbet.classes.Sport
import org.wireforce.virbet.dto.KtorEventSlim
import org.wireforce.virbet.factory.RetrofitFactory
import kotlin.system.measureTimeMillis


fun searchEvents(
	name: String,
	limit: Int = 8,
	offset: Int = 0,
) {

}


abstract class Factory {
	companion object {
		const val WIN_FIRST_TEAM = 1
		const val WIN_DRAW = -2
		const val WIN_SECOND_TEAM = 3

		const val TOTAL_1 = 4_001
		const val TOTAL_2 = 4_002
		const val TOTAL_3 = 4_004

		val totals by lazy {
			listOf(TOTAL_1, TOTAL_2, TOTAL_3)
		}

		val winsGroup by lazy {
			listOf(WIN_FIRST_TEAM, WIN_DRAW, WIN_SECOND_TEAM)
		}

		fun getAllFactory() =
			listOfNotNull(
				totals,
				winsGroup,
			)
			.flatten()

		fun KtorEventSlim.getPrimaryFactoriesForPreview() = hashMapOf(
			WIN_FIRST_TEAM to factors.find { it.factorId == WIN_FIRST_TEAM },
			WIN_DRAW to factors.find { it.factorId == WIN_DRAW },
			WIN_SECOND_TEAM to factors.find { it.factorId == WIN_SECOND_TEAM },
		)
	}
}

fun  Long.toFormattedString() = String.format("%,d", this)

fun useThisTest(countOfRequests: Int) {
	val jwt = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJ2aXJiZXQtYXVkaWVuY2UiLCJpc3MiOiJodHRwczovL3ZpcmJldC5pbyIsInRva2VuIjoiaHp1dW5TOEVNMmJyUHk0Q20xanpZcUJLYmxmb0ZxbzBUNFZjdW5RajZObkZ0VWo1RTZDM3VjT3lJSGpqOGZxTUg1bUwtRFAxU1FWa3JUSnEwMk9IeHciLCJleHAiOjE3MDEwOTQ5NTV9.1xGR0OREKRX6cLescft8dtTVDa5UDML0OE1JWe2T9zQ"

	val listOfExecuted = mutableListOf<Long>()

	(1..countOfRequests).onEach { _ ->
		val timeOfExecute = measureTimeMillis {
			val service = RetrofitFactory
				.getInstance("http://31.214.157.126:89")
				.service
				.getRelevantEvents(
					"Bearer $jwt",
					ContentLanguage.EN,
					Sport.BASEBALL
				)

			val events = service.execute().body()?.data

			events?.events?.onEach { event ->
				// CARD SOURCE CODE
				event.eventName

				val primaryFactors = event.getPrimaryFactoriesForPreview().toList()
			}
		}

		listOfExecuted.add(timeOfExecute)
	}

	val filteredList = listOfExecuted.filter { it > 0 }

	println("MIN executed time: " + filteredList.min().toFormattedString() + " ms.")
	println("MAX executed time: " + filteredList.max().toFormattedString() + " ms.")
	println("MEAN executed time: " + filteredList.average().toLong().toFormattedString() + " ms.")

}

fun main() {
	fun  String.toBearer() = ""



//	listOf(
//		1, 2, 3, 4,
//		1, 2, 3, 4,
//		1, 2, 3, 4,
//		1, 2, 3, 4,
//	)
//
//	searchEvents("Footbal", 4, 0)
//	searchEvents("Footbal", 4, 4)
//

////	val gson = GsonBuilder().setPrettyPrinting().create()
//
//


//	(1 until 500).onEach {
//		thread {
//			useThisTest(50)
//		}
//	}

//	val idKey = RetrofitFactory
//		.getInstance("http://localhost:8080")
//		.service
//		.requestIdKey()
//
//	println(idKey.execute().body())

//	RetrofitFactory
//		.getInstance("http://localhost:8080")
//		.service
//		.signup(
//			KtorCreateUser(
//				"dfgdfgdfgfdfgfdg",
//				"dgfdfgddfgdfg",
//				"DDNUDYVETRGWHVDVCFYCOHTVZADQTVMW"
//			)
//		)
//		.execute()
//		.let {
//			println(it.errorBody()?.string())
//		}


//	service
//		.login(
//			KtorLoginUser(
//				"dfgdfgdfgfdfgfdg",
//				"dgfdfgddfgdfg",
//			)
//		)
//		.execute()
//		.let {
//			val jwt = it.body()?.data?.jwtToken
//
//			println(service.getMe("Bearer $jwt").execute().body())
//			println(service.getBalance("Bearer $jwt").execute().body())
//			println(service.createBalanceIfNotExists("Bearer $jwt").execute().body())
//
//			println(jwt)
//		}

//	service
//		.login(
//			KtorLoginUser(
//				"dfgdfgdfgfdfgfdg",
//				"dgfdfgddfgdfg",
//			)
//		)
//		.execute()
//		.let {
//			val jwt = it.body()?.data?.jwtToken
//
//			println(service.getRelevantEvents("Bearer $jwt", Sport.BASEBALL, 90).execute().body())
//
//			println(jwt)
//		}
}
import MemoryTime.Companion.metric
import MemoryTime.Companion.printResults
import org.wireforce.virbet.classes.AuthFlowErrorCode
import org.wireforce.virbet.classes.ContentLanguage
import org.wireforce.virbet.classes.JWT
import org.wireforce.virbet.classes.JWT.Companion.toBearer
import org.wireforce.virbet.classes.Sport
import org.wireforce.virbet.dto.KtorAuthThoughIdKey
import org.wireforce.virbet.factory.RetrofitFactory
import org.wireforce.virbet.factory.RetrofitFactory.Companion.callInForeground

fun main() {
	val client = RetrofitFactory.getServiceInstance("http://localhost:8080")

	println(
		JWT.isValidAndroidJwtToken(Example.exampleJwtToken)
	)

	println(
		JWT.isJwtExpired(Example.exampleJwtToken)
	)

	println(
		JWT.isNeedUpdateJwt(Example.exampleJwtToken)
	)

	val bearer = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJ2aXJiZXQtYXVkaWVuY2UiLCJpc3MiOiJodHRwczovL3ZpcmJldC5pbyIsInRva2VuIjoiRjZKSkF4R0hfZlh3OHhXRGFpU1N0RnBXd2pfeU1FekhKd1lNNGc3UzhuS2tiLVBDVXlna2lmaXZnRVU3dzhwelFyYmVBQ1JlN0pKdkpBVTRUT3ZuRnciLCJleHAiOjE3MDExMjc4NDJ9.d9SHZ8QKM47-o7dX-XYioQl_mCkNt2khIw4c_oqEgJU".toBearer()


//		.generateAnonymousIDKey("REQUEST")
//		.login(KtorAuthThoughIdKey("SLONOPYQSBBHFVRUULPZGITDNEATZISA"))
//		.signup(
//			KtorCreateUser(
//				"admin12345",
//				"admin1234",
//				"SLONOPYQSBBHFVRUULPZGITDNEATZISA"
//			)
//		)

//		.login(
//			KtorLoginUser(
//				"admin12345",
//				"admin1234",
//			)
//		)
////		.getMe()

	metric(10, true) {
		client

			.login(KtorAuthThoughIdKey(""))
			.callInForeground()
	}.printResults()


//	metric(100, true) {
//		client
//			.getRelevantEvents(bearer, ContentLanguage.EN, Sport.BASEBALL)
//			.callInForeground(onSuccess = {
//				println(it.results?.executedTime)
//			})
//	}



//	TestFactoryRetrofit
//		.service
//		.login()
}
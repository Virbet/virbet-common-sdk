import org.wireforce.virbet.factory.RetrofitFactory

class TestFactoryRetrofit {
	companion object {
		val service = RetrofitFactory
			.getInstance("http://localhost:8080")
			.service
	}
}
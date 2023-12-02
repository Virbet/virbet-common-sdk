import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.wireforce.virbet.classes.ESL2
import org.wireforce.virbet.classes.ESL2.Companion.eq
import org.wireforce.virbet.classes.ESL2.Companion.from
import org.wireforce.virbet.classes.ESL2.Companion.like
import org.wireforce.virbet.classes.ESL2.Companion.lt
import org.wireforce.virbet.classes.ESL2.Companion.not
import org.wireforce.virbet.classes.ESL2.Companion.only
import org.wireforce.virbet.classes.ESL2.Companion.or
import org.wireforce.virbet.classes.ESL2.Companion.select
import org.wireforce.virbet.classes.Sport
import org.wireforce.virbet.classes.ESL2.Named.*
import org.wireforce.virbet.classes.EventsProvider
import org.wireforce.virbet.factory.GsonFactory
import java.net.URL

fun main() {
	runBlocking {
		val events = EventsProvider(URL("https://events.wireforcegamingcentral.space/"))
			.queryCall(
				from (Sport.FOOTBALL) select {

				}
			)

		println(events)
	}
}
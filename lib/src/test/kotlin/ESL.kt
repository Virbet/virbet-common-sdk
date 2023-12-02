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
import org.wireforce.virbet.factory.GsonFactory

fun main() {
	val out = from (Sport.CLIMBING, Sport.FENCING) select {
		use(
			not(
				TEAM_2 eq or(
					"",
					"",
					""
				)
			),

			TEAM_1 eq or(),

			TEAM_1 eq only("")
		)
	}
}
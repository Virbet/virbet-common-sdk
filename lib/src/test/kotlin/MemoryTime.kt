import kotlin.system.measureTimeMillis

class MemoryTime {
	companion object {
		fun List<Long>.printResults() {
			println("MIN executed time: " + min().toFormattedString() + " ms.")
			println("MAX executed time: " + max().toFormattedString() + " ms.")
			println("MEAN executed time: " + average().toLong().toFormattedString() + " ms.")
		}

		fun metric(countOfTests: Int = 1, noPrint: Boolean = false, runnable: Runnable): List<Long> {
			val listOfExecuted = mutableListOf<Long>()

			(0..countOfTests).mapIndexed { index, i ->
				val timeOfExecute = measureTimeMillis {
					runnable.run()
				}

				listOfExecuted.add(timeOfExecute)

				if (!noPrint) {
					println("[✅ TEST $index] Passed for ${timeOfExecute.toFormattedString()} ms.")
				}
			}

			return listOfExecuted.filter { it > 0 }
		}
	}
}
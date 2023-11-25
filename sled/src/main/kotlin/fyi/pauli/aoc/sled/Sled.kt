package fyi.pauli.aoc.sled

import Task
import com.github.ajalt.mordant.rendering.TextColors.red
import fyi.pauli.aoc.sled.prompt.askDay
import fyi.pauli.aoc.sled.prompt.askYear
import terminal

/**
 * @author Paul Kindler
 * @since 25/11/2023
 */
fun main() = Sled().handOutGifts()

class Sled {

	private val collection: Map<Int, Set<Task>> = mapOf(

	)

	fun handOutGifts() {
		val year = askYear(terminal)

		if (!collection.containsKey(year)) {
			terminal.println(red("Sadly this year is not implemented yet."))
			handOutGifts()
			return
		}

		val yearCollection = collection[year]!!

		val day = askDay(terminal)

		val task = yearCollection.find { it.localDate.dayOfMonth == day }

		if (task == null) {
			terminal.println(red("Sadly this day is not implemented yet."))
			handOutGifts()
			return
		}

		task.run()
	}
}
package fyi.pauli.aoc.sled.prompt

import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyles
import com.github.ajalt.mordant.terminal.Terminal
import java.util.*

/**
 * @author Paul Kindler
 * @since 25/11/2023
 */

private val lastYear = Calendar.getInstance().get(Calendar.YEAR)

fun askYear(terminal: Terminal): Int {
	val year = terminal.prompt(
		TextColors.green(
			"From ${(TextColors.red + TextStyles.bold)("which year")} " +
					TextColors.green("you want run the task. ") +
					(TextColors.yellow + TextStyles.bold)("[2015-$lastYear]")
		)
	)?.toIntOrNull()

	if (year == null || !(2015..lastYear).contains(year)) {
		terminal.println(
			TextColors.red(
				"This in an invalid year. " +
						(TextColors.yellow + TextStyles.bold)("[2015-$lastYear]")
			)
		)
		askYear(terminal)
	}

	return year!!
}

fun askDay(terminal: Terminal): Int {
	val day = terminal.prompt(
		TextColors.green(
			"From ${(TextColors.red + TextStyles.bold)("which day")} " +
					TextColors.green("you want run the task. ") +
					(TextColors.yellow + TextStyles.bold)("[1-24]")
		)
	)?.toIntOrNull()

	if (day == null || !(1..24).contains(day)) {
		terminal.println(
			TextColors.red(
				"This in an invalid day. " +
						(TextColors.yellow + TextStyles.bold)("[1-24]")
			)
		)
		askYear(terminal)
	}

	return day!!
}

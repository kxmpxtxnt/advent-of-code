package fyi.pauli.aoc.v2015.days

import com.github.ajalt.mordant.rendering.TextColors
import invoke
import terminal

/**
 * @author Paul Kindler
 * @since 27/11/2023
 */
val firstOf2015 = 2015.1 {

	first {
		var i = 0
		input.forEach {
			when (it) {
				'(' -> i++
				')' -> i--
			}
		}
		i

	}

	second {
		var i = 0
		input.forEachIndexed { index, c ->
			when (c) {
				'(' -> i++
				')' -> i--
			}

			if (i < 0) {
				terminal.println(TextColors.red("Below 0 -> $index"))
				return@second index + 1
			}
		}
	}
}
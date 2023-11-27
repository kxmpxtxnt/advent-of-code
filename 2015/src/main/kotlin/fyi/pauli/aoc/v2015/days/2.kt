package fyi.pauli.aoc.v2015.days

import invoke
import java.math.BigInteger
import kotlin.math.min

/**
 * @author Paul Kindler
 * @since 27/11/2023
 */
val secondOf2015 = 2015.2 {
	first {
		var overall: Long = 0
		inputLines.forEach { line ->
			val (lowest, middle, highest) = line.split("x").map { it.toLong() }.sortedDescending().reversed()

			val area = (2L * lowest * middle) + (2L * middle * highest) + (2L * highest * lowest) + (lowest * middle)

			overall += area
		}

		overall
	}

	second {
		var ribbon: Long = 0
		inputLines.forEach { line ->
			val (lowest, middle, highest) = line.split("x").map { it.toLong() }.sortedDescending().reversed()

			ribbon += (2L * lowest + 2L * middle) + lowest * middle * highest
		}

		ribbon
	}
}
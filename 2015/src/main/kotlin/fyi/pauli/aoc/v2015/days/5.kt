package fyi.pauli.aoc.v2015.days

import invoke

/**
 * @author Paul Kindler
 * @since 27/11/2023
 */
val fifthOf2015 = 2015.5 {
	first {
		inputLines.count { line ->
			!(listOf("ab", "cd", "pq", "xy").any { line.contains(it) }) &&
					line.count { "aeiou".contains(it) } >= 3 &&
					line.zipWithNext().any { (first, second) -> first == second }

		}

	}

	second {
		fun hasPairWithoutOverlap(line: String): Boolean {
			for (i in 0 until line.length - 1) {
				val pair = line[i].toString() + line[i + 1]
				if (line.indexOf(pair, i + 2) != -1) {
					return true
				}
			}
			return false
		}

		fun hasRepeatingLettersWithoutOneBetween(line: String): Boolean {
			for (i in 0 until line.length - 2) {
				if (line[i] == line[i + 2]) {
					return true
				}
			}
			return false
		}


		inputLines.count {
			hasPairWithoutOverlap(it) && hasRepeatingLettersWithoutOneBetween(it)
		}
	}
}
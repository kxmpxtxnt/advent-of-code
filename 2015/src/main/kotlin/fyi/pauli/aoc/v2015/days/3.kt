package fyi.pauli.aoc.v2015.days

import invoke

/**
 * @author Paul Kindler
 * @since 27/11/2023
 */
val thirdOf2015 = 2015.3 {
	first {
		val locations: MutableSet<Pair<Long, Long>> = mutableSetOf()
		var currentLocation = Pair(0L, 0L)

		input.forEach { c ->
			currentLocation = when (c) {
				'>' -> Pair(currentLocation.first + 1, currentLocation.second)
				'<' -> Pair(currentLocation.first - 1, currentLocation.second)
				'^' -> Pair(currentLocation.first, currentLocation.second + 1)
				'v' -> Pair(currentLocation.first, currentLocation.second - 1)
				else -> currentLocation
			}

			locations += currentLocation
		}

		locations.size + 1
	}

	second {
		val locations = mutableSetOf<Pair<Long, Long>>()
		val currentLocation = mutableMapOf(true to Pair(0L, 0L), false to Pair(0L, 0L))

		var isSanta = true

		input.forEach { c ->
			currentLocation[isSanta] = when (c) {
				'>' -> Pair(currentLocation[isSanta]!!.first + 1, currentLocation[isSanta]!!.second)
				'<' -> Pair(currentLocation[isSanta]!!.first - 1, currentLocation[isSanta]!!.second)
				'^' -> Pair(currentLocation[isSanta]!!.first, currentLocation[isSanta]!!.second + 1)
				'v' -> Pair(currentLocation[isSanta]!!.first, currentLocation[isSanta]!!.second - 1)
				else -> currentLocation[isSanta]!!
			}

			locations += currentLocation[isSanta]!!
			isSanta = !isSanta
		}

		locations.size
	}
}


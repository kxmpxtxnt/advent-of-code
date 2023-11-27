package fyi.pauli.aoc.v2015.days

import invoke
import java.security.MessageDigest

/**
 * @author Paul Kindler
 * @since 27/11/2023
 */


val forthOf2015 = 2015.4 {
	val md = MessageDigest.getInstance("MD5")

	fun calculateMD5(input: String): String {
		val bytes = md.digest(input.toByteArray())
		return bytes.joinToString("") { "%02x".format(it) }
	}

	fun mineAdventCoin(secretKey: String, match: String): Int {
		var number = 1

		while (true) {
			val input = "$secretKey$number"
			val md5Hash = calculateMD5(input)

			if (md5Hash.startsWith(match)) {
				return number
			}

			number++
		}
	}



	first {
		mineAdventCoin(input, "00000")
	}

	second {
		mineAdventCoin(input, "000000")
	}
}
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.readLines
import kotlin.io.path.readText
import kotlin.time.measureTime

/**
 * @author Paul Kindler
 * @since 24/11/2023
 */
operator fun Double.invoke(run: DecemberDay.() -> Unit) {
	val (year, day) = this.toString().split(".").map { it.toInt() }
	DecemberDay(year, day, run).start()
}

open class DecemberDay(
	year: Int,
	day: Int,
	val run: DecemberDay.() -> Unit
) {

	private val path: Path = Paths.get("./inputs/", "$year-$day.txt")

	val inputLines: MutableSet<String> = path.readLines().toMutableSet()
	var input: String = path.readText()

	private var first: (() -> Any) = {}

	fun first(runFirst: () -> Any) {
		first = runFirst
	}

	private var second: (() -> Any) = {}

	fun second(runSecond: () -> Any) {
		second = runSecond
	}

	private fun startPart(partName: String, partBlock: (() -> Any)) {
		var outcome: Any?

		val time = measureTime {
			outcome = partBlock.invoke()
		}.inWholeNanoseconds

		println("Outcome of '$partName' is '$outcome', it took ${time}ms to finish.")
	}

	fun start() {
		run()
		startPart("Part 1", first)
		run()
		startPart("Part 2", second)
	}
}
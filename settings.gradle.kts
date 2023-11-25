rootProject.name = "advent-of-code"

include(
	"aoc",
	"sled"
)

(2015..2023).forEach {
	include(it.toString())
}
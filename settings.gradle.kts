rootProject.name = "advent-of-code"

include(
	"aoc"
)

dependencyResolutionManagement {
	versionCatalogs {
		create("libs") {
			library("kotlinx", "org.jetbrains.kotlinx", "kotlinx-io-core").version("0.3.0")
		}
	}
}
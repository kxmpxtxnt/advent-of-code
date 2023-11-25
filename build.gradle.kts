plugins {
	kotlin("jvm") version "1.9.21"
}

repositories {
	mavenCentral()
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")

	repositories {
		mavenCentral()
	}

	dependencies {
		implementation(kotlin("stdlib-jdk8"))
		implementation("org.jetbrains.kotlinx", "kotlinx-datetime", "0.4.1")
		implementation("com.github.ajalt.mordant", "mordant", "2.2.0")

		when (project.name) {
			"sled" -> {
				implementation(project(":aoc"))
				implementation(kotlin("reflect"))
				(2015..2023).forEach {
					implementation(project(":$it"))
				}
			}

			else -> {
				if (project.name != "aoc") implementation(project(":aoc"))
			}
		}
	}
}
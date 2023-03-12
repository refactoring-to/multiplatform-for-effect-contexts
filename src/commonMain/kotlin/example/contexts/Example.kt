package example.contexts


expect class Instant : Comparable<Instant>

interface Clock {
    fun now(): Instant
}

expect class SystemClock : Clock

fun Clock.doIt() {
    val i = now()
    println("produces: $i")
}

fun shouldNotCompile() {
    // IntelliJ correctly highlights this as an unresolved reference error, but the JVM compiler compiles it
    val i : Instant = Instant.now()
    println("should not compile, but does and produces: $i")
}

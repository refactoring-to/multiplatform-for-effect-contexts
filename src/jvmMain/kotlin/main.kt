package example.contexts

actual typealias Instant = java.time.Instant

actual class SystemClock : Clock {
    override fun now(): Instant {
        return Instant.now()
    }
}

fun main() {
    with(SystemClock()) {
        doIt()
    }
    
    shouldNotCompile()
}

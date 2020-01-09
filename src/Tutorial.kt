import java.util.*

fun main(args: Array<String>) {
    println(1 shl 10)
//    wrappingWithSomething()
}

fun responseToInput(input: String) = when (input) {
    "y", "yes" -> "I'm glad to meet you"
    "n", "no" -> "I'm not glad to meet you"
    else -> "This is not right!!"
}

fun wrappingWithSomething() {
    when (val a = getPet()) {
        is Cat -> a.meow()
        is Dog -> a.meow()
        else -> println("Something Wrong!")
    }

}

fun getPet(): Pet {
    return Cat()
}
package scope_functions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {
    val strings = mutableListOf("1", "2", "3", "4")

    val firstString = strings.run {
        println(get(0))
        println(get(1))
        println(get(2))
        forEach(::print)
        println()
        get(0)
    }
    println("first element of strings : $firstString")
}
/**
 * run() 은 약간 apply + let의 느낌이다.
 * receiver를 사용해서 this를 인자로 받고 block의 리턴값을 리턴하게 된다.
 */

/**
 * Calls the specified function [block] and returns its result.
 *
 * For detailed usage information see the documentation for [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#run).
 */
@ExperimentalContracts
public inline fun <R> runFromStandardKT(block: () -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}

/**
 * Calls the specified function [block] with `this` value as its receiver and returns its result.
 *
 * For detailed usage information see the documentation for [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#run).
 */
@ExperimentalContracts
public inline fun <T, R> T.runFromStandardKT(block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}
package scope_functions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {
    val strings = mutableListOf("1", "2", "3", "4")
    val first = with(strings) {
        println(get(0))
        println(get(1))
        println(get(2))
        forEach(::print)
        println()
        get(0)
    }
    println(first)
}

/**
 * @param receiver T
 * @param block T.() -> R
 * @return R block의 return값
 * with()
 *
 *  run() 함수와 거의 같고 receiver가 인자로 오느냐 혹은 현재 객체를 바로 receiver로 넘기냐의 차이다.!
 *  run()은 결국
 *  someObject.let{
 *      with(it){
 *
 *      }
 *  }
 *  이런식으로 let() + with()이라고 생각할 수 있다.
 */


/**
 * Calls the specified function [block] with the given [receiver] as its receiver and returns its result.
 *
 * For detailed usage information see the documentation for [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#with).
 */
@ExperimentalContracts
public inline fun <T, R> withFromStandardKT(receiver: T, block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return receiver.block()
}
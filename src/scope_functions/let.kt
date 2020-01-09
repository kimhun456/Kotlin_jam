package scope_functions

import java.util.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main(args: Array<String>) {

    val list = mutableListOf(1, 2, 3, 4)
    println(list.let {
        it.forEach(::println)
        it[0]
    })

    // 이 부분은 결국 자기 자신을 return했으니까 apply 가 더 맞을듯?
    val currentTime = System.currentTimeMillis().let {
        println(Date(it))
        it
    }
    println("Miilliseconds from 1970, 1, 1 : $currentTime")

    var name: String? = null

    // Null 이면 let의 block이 실행되지 않는다.
    name?.let { println(it) }

    name = "hyunjae"
    name?.let { println(it) }

}

/**
let -> let은 함수를 호출하는 객체를 이어지는 블록의 인자로 넘기고
블록의 결과값을 반환한다.
함수를 호출한 객체를 인자로 받으므로, 이를 사용하여 다른 메서드를 실행하거나 연산을 수행해야하는 경우 사용할 수 있다.
 */


/**
 * Calls the specified function [block] with `this` value as its argument and returns its result.
 *
 * For detailed usage information see the documentation for [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#let).
 */
@ExperimentalContracts
public inline fun <T, R> T.letFromStandardKT(block: (T) -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block(this)
}
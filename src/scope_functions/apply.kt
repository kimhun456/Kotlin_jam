package scope_functions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

fun main() {
    val strings = mutableListOf("1", "2", "3")

    println(strings)

    val convertedString = mutableListOf("1", "2", "3").apply {
        println(get(0))
        add("4")
        add("5")
    }
    println(convertedString)

    strings.apply {
        forEach(::print)
    }
}

/**
apply는 함수를 호출하는 객체를 이어지는 block의 receiver로 전달하고
그 객체 자체를 반환한다.
Receiver == 리시버란, 바로 이어지는 블록 내에서 메서드 및 속성에 바로 접근할 수 있도록 할 객체를 의미합니다.
@link{https://kotlinlang.org/docs/reference/lambdas.html#function-literals-with-receiver}
 */

@ExperimentalContracts
public inline fun <T> T.applyFromStandardKT(block: T.() -> Unit): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
    return this
}
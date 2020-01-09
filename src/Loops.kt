import java.util.*

fun main() {
    val child: Person = Child()
    child.foo()


    val list = listOf<String>("exe", "exe", "exe", "msi", "oth")
}

fun Person.foo() {
    println("foo from parent")
}

fun Child.foo() {
    println("foo from Child")
}

open class Person

class Child : Person() {

}
package v_builders.examples

import java.util.*

fun todoTask38(): Nothing = TODO(
    """
        Task 38.
        The previous examples can be rewritten with the library function 'apply' (see examples below).
        Write your own implementation of the function 'apply' named 'myApply'.
    """
)

fun <T> T.myApply(f: T.() -> Unit): T {
    this.f()
    return this
}

//fun StringBuilder.myApply(f: StringBuilder.() -> Unit): String{
//    val str = StringBuilder()
//    str.f()
//    return str.toString()
//}
//
//fun Map<Int, String>.myApply(f: HashMap<Int, String>.() -> Unit): Map<Int, String>{
//    val map = hashMapOf<Int, String>()
//    map.f()
//    return map
//}

fun buildString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun buildMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
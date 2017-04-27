package vi_generics

import util.TODO
import java.util.*

fun task41(): Nothing = TODO(
        """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun <E, T> T.partitionTo(origin: MutableCollection<E>, foo: MutableCollection<E>, bar: (E) -> Boolean): Pair<T, T> {
    println(this)
    val x = (this as Collection<E>).partition(bar)
    val left = x.first
    left.toCollection(origin)
    val right = x.second
    right.toCollection(foo)
    return Pair(origin as T, foo as T)
}

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
}
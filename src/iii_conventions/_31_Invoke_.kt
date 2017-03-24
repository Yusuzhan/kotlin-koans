package iii_conventions

import util.TODO


class Invokable {


    var count = 0

    fun getNumberOfInvocations(): Int = count
    operator fun  invoke(): Invokable{
        count++
        return this
    }

}

class Foo2{
    operator fun invoke() {
        println("invoke")
    }

}

fun main(args: Array<String>) {
    val  f: Foo2 = Foo2()
    f()
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    //todoTask31()
    return invokable()()()().getNumberOfInvocations()
}



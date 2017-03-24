package iii_conventions

import iii_conventions.TimeInterval.*
import java.util.*

fun MyDate.nextDay() = addTimeIntervals(DAY, 1)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate{
    return this.addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(r: RepeatedTimeInterval): MyDate{
    return this.addTimeIntervals(r.ti, r.n)
}

operator fun TimeInterval.times(n: Int): RepeatedTimeInterval{
    return RepeatedTimeInterval(this, n)
}


class RepeatedTimeInterval(val ti: TimeInterval, val n: Int){

}

fun MyDate.addTimeIntervals(timeInterval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year + if (timeInterval == YEAR) number else 0, month, dayOfMonth)
    var timeInMillis = c.timeInMillis
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    timeInMillis += number * when (timeInterval) {
        DAY -> millisecondsInADay
        WEEK -> 7 * millisecondsInADay
        YEAR -> 0L
    }
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMillis
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
}
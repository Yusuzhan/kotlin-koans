package iii_conventions

import syntax.ifWhenExpressions.ifExpression
import syntax.qualifiedThis.labelsForExtensionFunctionLiterals

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        //return this.toString().toInt() - other.toString().toInt()
        return when {
            other.year != year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
    }

    override fun toString(): String {
        //return "$year ${if (month< 10) month.toString() else 0$month}"
        return "$year" +
                "${if (month >= 10) month else "0" + month}" +
                "${if (dayOfMonth >= 10) dayOfMonth else "0" + dayOfMonth}"
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange =
        DateRange(this, other)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterator<MyDate> {

    var currentDate: MyDate = start

    override fun hasNext(): Boolean {
        return currentDate <= endInclusive
    }


    override fun next(): MyDate {
        val temp = currentDate
        currentDate = currentDate.nextDay()
        return temp
    }
}


package com.example.smarthomeproject


fun main() {
    /*var e:Manager= Manager("benam","dfsdf",10.2)
        println(e.getname())*/
var xx= mutableMapOf("xx" to 1,"zz" to 2)

    xx["xx"]= xx["xx"]!! +1
    val sum = { x: Int, y: Int -> x + y }
    var list = listOf(5, 1, 7, 4, 11, 6)
    list.max()
    val x: Int? = null
    val charList = charArrayOf('a', 'd', 'z', 'q')
    val charList2 = charArrayOf('a', 'b', 'c', 'q')
    charList.filter { charList2.contains(it) }
    list.reduce { acc, num -> acc + num }
// println(charList.map { it.uppercaseChar() })
    val z = "hello"
    z.reversed()

    val num2 = 123456
    list.distinct()
    println(xx["xx"])
    /*    val milk: commodity = commodity("white", 2)
        println(milk.hashCode())
        val (color, number) = milk
        println(color)
        val test: (Int, Int) -> Int = { i, j -> i + j }

        val i by lazy { }*/

}

fun numreverse(x: Int): Int {
    var x1 = x
    var y = 0
    while (x1 != 0) {
        y *= 10
        y += x1 % 10
        x1 = x1/10
    }
    return y
}

fun numberToName(num: Int) = when (num) {
    0 -> "zero"
    1 -> "one"
    2 -> "two"
    3 -> "three"
    4 -> "four"
    5 -> "five"
    6 -> "six"
    7 -> "seven"
    8 -> "eight"
    9 -> "nine"
    else -> ""
}

fun biggerNumber(a: Int, b: Int) = if (a > b) a else b

fun loopTest(): Int {


    val characters = listOf("a", "b", "c")
    for (i in characters)
        println(i)
    return 0
}

fun whenExp(x: Any) =
    when (x) {
        is Int -> "it is int"
        is String -> "it is string"
        else -> "don't know"
    }
/*when {
   x is Int -> "it is int"
   x is String -> "it is string"
    else -> "don't know"
}*/

public class Persion(x: Int, var y: String)


open public class Employee(name: String, var phone: String) {
    var fullname: String
        get() = "$name : $phone"
        set(vale) {
            name = vale
        }

    lateinit var name: String

    init {
        this@Employee.name = name
    }

    open fun getsalary() = "10000"
    fun getname() = name
}

//اگر بخوایم تو متد ها از پارامتر ها  استفاده کنیم باید val یا var مشخص باشد
class Manager(name: String, phone: String, val salary: Double) : Employee(name, phone) {

    override fun getsalary() = "15000"
}

data class commodity(val color: String, val quantity: Int)


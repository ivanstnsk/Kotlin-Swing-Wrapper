package me.airomad.kotlinswingwrapper

/**
 * Created by Airomad on 18.02.2017.
 *
 */

fun main(args: Array<String>) {
    test { 10 AND 20 }
}

fun test(block: () -> Int) {
    println(block())
}

infix fun Int.AND(one: Int): Int = this.plus(one)
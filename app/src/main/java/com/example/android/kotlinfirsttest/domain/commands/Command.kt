package com.example.android.kotlinfirsttest.domain.commands

/**
 * Created by Dawid on 2017-08-07.
 */

/*These commands will execute an operation and return an object of the class specified
in its generic type.*/
interface Command<out T> {
    fun execute(): T
}

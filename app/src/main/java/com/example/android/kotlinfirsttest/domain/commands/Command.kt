package com.example.android.kotlinfirsttest.domain.commands

/**
 * Created by Dawid on 2017-08-07.
 */
interface Command {

    interface Command<out T> {
        fun execute(): T
    }
}
package com.teamsparta.todocards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodocardsApplication

fun main(args: Array<String>) {
    runApplication<TodocardsApplication>(*args)
}

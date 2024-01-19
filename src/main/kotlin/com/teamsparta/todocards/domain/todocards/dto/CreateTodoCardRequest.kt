package com.teamsparta.todocards.domain.todocards.dto

import com.teamsparta.todocards.domain.todocards.model.TodoCard

data class CreateTodoCardRequest(
    val title: String,
    val content: String,
    val name: String
) {

    fun toTodoCard(): TodoCard{
        return TodoCard(
            title = title,
            content = content,
            name = name
        )

    }
}
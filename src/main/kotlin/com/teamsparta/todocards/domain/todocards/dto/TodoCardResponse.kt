package com.teamsparta.todocards.domain.todocards.dto

import com.teamsparta.todocards.domain.todocards.model.TodoCard

data class TodoCardResponse(
    var id: Long?,
    var title: String,
    var content: String,
    var createdAt: String,
    var name: String
) {
    companion object{

        fun toTodoCardResponse(todoCard: TodoCard): TodoCardResponse{
            return TodoCardResponse(
                id = todoCard.id,
                title = todoCard.title,
                content = todoCard.content,
                createdAt = todoCard.createdat,
                name = todoCard.name

            )
        }
    }
}
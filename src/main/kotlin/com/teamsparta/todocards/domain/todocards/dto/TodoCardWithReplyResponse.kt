package com.teamsparta.todocards.domain.todocards.dto

import com.teamsparta.todocards.domain.todocards.model.TodoCard

class TodoCardWithReplyResponse(
    val id: Long?,
    val title: String,
    val content: String,
    val createdAt: String,
    val name: String
) {

    companion object {
        fun toTodoCardWithReplyResponse(todoCard: TodoCard): TodoCardWithReplyResponse {
            return TodoCardWithReplyResponse(
                id = todoCard.id,
                title = todoCard.title,
                content = todoCard.content,
                createdAt = todoCard.createdat,
                name = todoCard.name)
        }
    }
}
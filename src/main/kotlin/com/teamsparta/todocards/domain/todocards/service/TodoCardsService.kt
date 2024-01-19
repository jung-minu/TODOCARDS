package com.teamsparta.todocards.domain.todocards.service

import com.teamsparta.todocards.domain.todocards.dto.CreateTodoCardRequest
import com.teamsparta.todocards.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todocards.domain.todocards.dto.TodoCardWithReplyResponse
import com.teamsparta.todocards.domain.todocards.dto.UpdateTodoCardRequest
import javax.swing.SortOrder

interface TodoCardsService {

    fun createTodoCard(request: CreateTodoCardRequest): TodoCardResponse

    fun getAllTodoCardList(sortOrder: SortOrder): List<TodoCardResponse>

    fun getTodoCardById(todoCardId: Long): TodoCardWithReplyResponse

    fun updateTodoCard(todoCardId: Long, request: UpdateTodoCardRequest): TodoCardResponse

    fun deleteTodoCard(todoCardId: Long)
}
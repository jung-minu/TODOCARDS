package com.teamsparta.todocards.domain.todocards.repository

import com.teamsparta.todocards.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todocards.domain.todocards.model.TodoCard
import org.springframework.data.jpa.repository.JpaRepository

interface TodoCardRepository: JpaRepository<TodoCard, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<TodoCardResponse>

    fun findAllByOrederByCreatedAtAsc(): List<TodoCardResponse>
}
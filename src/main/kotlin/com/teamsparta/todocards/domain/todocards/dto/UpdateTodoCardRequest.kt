package com.teamsparta.todocards.domain.todocards.dto

data class UpdateTodoCardRequest(
    val title: String?,
    val content: String?,
    val name: String
)
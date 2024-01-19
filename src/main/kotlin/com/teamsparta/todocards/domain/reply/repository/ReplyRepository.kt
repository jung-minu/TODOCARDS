package com.teamsparta.todocards.domain.reply.repository

import com.teamsparta.todocards.domain.reply.model.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository: JpaRepository<Reply, Long> {
}
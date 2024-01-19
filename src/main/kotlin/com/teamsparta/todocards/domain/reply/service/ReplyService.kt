package com.teamsparta.todocards.domain.reply.service

import com.teamsparta.todocards.domain.reply.dto.CreateReplyRequest
import com.teamsparta.todocards.domain.reply.dto.ReplyResponse
import com.teamsparta.todocards.domain.reply.dto.UpdateReplyRequest
import com.teamsparta.todocards.domain.reply.model.Reply

interface ReplyService {

    fun createReply(todoCardId: Long, createReplyRequest: CreateReplyRequest): ReplyResponse

    fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse

    fun deleteReply(replyId: Long)

    fun getReplyById(replyId: Long): Reply
}
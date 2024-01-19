package com.teamsparta.todocards.domain.reply.dto

import com.teamsparta.todocards.domain.exception.ModelNotFoundException
import com.teamsparta.todocards.domain.reply.model.Reply

class ReplyResponse(
    var id: Long?,
    var content: String,
    var createdAt: String,
    var todoCardId: Long
) {
    companion object{
        fun toReplyResponse(reply: Reply): ReplyResponse{
            return ReplyResponse(
                id = reply.id,
                content = reply.content,
                createdAt = reply.createdAt,
                todoCardId = reply.todoCard.id ?: throw ModelNotFoundException("todoCard", reply.todoCard.id)
            )
        }
    }

}
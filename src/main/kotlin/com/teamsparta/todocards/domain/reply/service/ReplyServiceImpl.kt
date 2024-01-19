package com.teamsparta.todocards.domain.reply.service

import com.teamsparta.todocards.domain.exception.ModelNotFoundException
import com.teamsparta.todocards.domain.reply.dto.CreateReplyRequest
import com.teamsparta.todocards.domain.reply.dto.ReplyResponse
import com.teamsparta.todocards.domain.reply.dto.UpdateReplyRequest
import com.teamsparta.todocards.domain.reply.model.Reply
import com.teamsparta.todocards.domain.reply.repository.ReplyRepository
import com.teamsparta.todocards.domain.todocards.repository.TodoCardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.ui.Model

@Service
class ReplyServiceImpl(
    private val replyRepository: ReplyRepository,
    private val todoCardRepository: TodoCardRepository
): ReplyService {
    override fun createReply(todoCardId: Long, createReplyRequest: CreateReplyRequest): ReplyResponse {
        val targetTodoCard = todoCardRepository.findByIdOrNull(todoCardId)
            ?: throw Exception("target post is not found")

        val reply = Reply(
            content = createReplyRequest.content,
            todoCard = targetTodoCard
        )

        val result = replyRepository.save(reply)

        return ReplyResponse.toReplyResponse(result)

    }

    override fun updateReply(replyId: Long, request: UpdateReplyRequest): ReplyResponse {
        val reply = replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        reply.content = request.content

        return ReplyResponse.toReplyResponse(reply)
    }

    override fun deleteReply(replyId: Long) {
        val reply = replyRepository.findByIdOrNull(replyId) ?: throw  ModelNotFoundException("Reply", replyId)

        replyRepository.delete(reply)
    }

    override fun getReplyById(replyId: Long): Reply {
        val reply = replyRepository.findByIdOrNull(replyId) ?: throw ModelNotFoundException("Reply", replyId)
        return reply
    }
}
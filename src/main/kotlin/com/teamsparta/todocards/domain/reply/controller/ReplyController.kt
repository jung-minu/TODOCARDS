package com.teamsparta.todocards.domain.reply.controller

import com.teamsparta.todocards.domain.reply.dto.CreateReplyRequest
import com.teamsparta.todocards.domain.reply.dto.ReplyResponse
import com.teamsparta.todocards.domain.reply.dto.UpdateReplyRequest
import com.teamsparta.todocards.domain.reply.service.ReplyService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/todocards/{todoCardId}/replies")
@RestController
class ReplyController(
    private val replyService: ReplyService) {

    @PostMapping
    fun createReply(
        @RequestParam todoCardId: Long,
        @RequestBody createReplyRequest: CreateReplyRequest
    ): ResponseEntity<ReplyResponse>{
        var result = replyService.createReply(todoCardId, createReplyRequest)

        return  ResponseEntity
            .status(HttpStatus.CREATED)
            .body(result)

    }

    @PutMapping("/{replyId}")
    fun updateReply(@PathVariable replyId: Long,
                    @RequestBody updateReplyRequest: UpdateReplyRequest): ResponseEntity<ReplyResponse>
    {
        val updateReply = replyService.updateReply(replyId, updateReplyRequest)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(updateReply)
    }

    @DeleteMapping("/{replyId}")

    fun deleteReply(@PathVariable replyId: Long): ResponseEntity<String>{
        replyService.deleteReply(replyId)

        val deleteReplySuccessMessage = "댓글이 성공적으로 삭제되었습니다."
                return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(deleteReplySuccessMessage)
    }

}
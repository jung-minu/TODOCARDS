package com.teamsparta.todocards.domain.todocards.controller

import com.teamsparta.todocards.domain.todocards.dto.CreateTodoCardRequest
import com.teamsparta.todocards.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todocards.domain.todocards.dto.TodoCardWithReplyResponse
import com.teamsparta.todocards.domain.todocards.dto.UpdateTodoCardRequest
import com.teamsparta.todocards.domain.todocards.service.TodoCardsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import javax.swing.SortOrder

@RequestMapping("/todoCards")

@RestController
class TodoCardsController(
    private val todoCardsService: TodoCardsService
) {
    @PostMapping
    fun createTodoCard(
        @RequestPart data: CreateTodoCardRequest
    ): ResponseEntity<Any>{
        todoCardsService.createTodoCard(data)

        return ResponseEntity.status(HttpStatus.CREATED).body("할 일 카드 생성 완료")
    }

    @PutMapping("/{todoCardId}")
    fun updateTodoCard(
        @PathVariable todoCardId: Long,
        @RequestBody updateTodoCardRequest: UpdateTodoCardRequest
    ): ResponseEntity<TodoCardResponse>{

        val saveTodoCard: TodoCardResponse = todoCardsService.updateTodoCard(todoCardId, updateTodoCardRequest)

        return ResponseEntity.status(HttpStatus.OK).body(saveTodoCard)
    }


    @GetMapping
    fun getAllTodoCardList(@RequestParam sortOrder: SortOrder): ResponseEntity<List<TodoCardResponse>>{
        return ResponseEntity.status(HttpStatus.OK).body(todoCardsService.getAllTodoCardList(sortOrder))
    }

    @GetMapping("/{postId}")
    fun getTodoCardId(@PathVariable todoCardId: Long):ResponseEntity<TodoCardWithReplyResponse>{
        val updateTodoCard = todoCardsService.getTodoCardById(todoCardId)
        return ResponseEntity.status(HttpStatus.OK).body(updateTodoCard)
    }

    @DeleteMapping("/{todoCardId}")
    fun deleteTodoCard(@PathVariable todoCardId: Long): ResponseEntity<String>{
        todoCardsService.deleteTodoCard(todoCardId)

        val deleteTodocardSuccessMessage = "할 일 카드가 성공적으로 삭제 되었습니다."

        return ResponseEntity.status(HttpStatus.OK).body(deleteTodocardSuccessMessage)
    }


}
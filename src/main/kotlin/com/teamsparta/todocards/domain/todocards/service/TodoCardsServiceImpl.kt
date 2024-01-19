package com.teamsparta.todocards.domain.todocards.service

import com.teamsparta.todocards.domain.exception.ModelNotFoundException
import com.teamsparta.todocards.domain.todocards.dto.CreateTodoCardRequest
import com.teamsparta.todocards.domain.todocards.dto.TodoCardResponse
import com.teamsparta.todocards.domain.todocards.dto.TodoCardWithReplyResponse
import com.teamsparta.todocards.domain.todocards.dto.UpdateTodoCardRequest
import com.teamsparta.todocards.domain.todocards.repository.TodoCardRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.swing.SortOrder

@Service
class TodoCardsServiceImpl(
    private val todoCardRepository: TodoCardRepository
): TodoCardsService {

    @Transactional
    override fun createTodoCard(request: CreateTodoCardRequest): TodoCardResponse {
        val todoCard = todoCardRepository.save(request.toTodoCard())
        return TodoCardResponse.toTodoCardResponse(todoCard)
    }

    override fun getAllTodoCardList(sortOrder: SortOrder): List<TodoCardResponse> {
        var todoCardList: List<TodoCardResponse> = listOf()
        if(sortOrder == SortOrder.DESCENDING){
            todoCardList = todoCardRepository.findAllByOrderByCreatedAtDesc()
        } else{
            todoCardList = todoCardRepository.findAllByOrederByCreatedAtAsc()
        }

        return todoCardList
    }

    override fun getTodoCardById(todoCardId: Long): TodoCardWithReplyResponse {

        val todoCard = todoCardRepository.findByIdOrNull(todoCardId) ?: throw ModelNotFoundException("TodoCard",todoCardId)
        return TodoCardWithReplyResponse.toTodoCardWithReplyResponse(todoCard)
    }


    @Transactional
    override fun updateTodoCard(todoCardId: Long, request: UpdateTodoCardRequest): TodoCardResponse {
        val savedTodoCard = todoCardRepository.findByIdOrNull(todoCardId) ?: throw ModelNotFoundException("TodoCard",todoCardId)
        savedTodoCard.updateTodocard(request)
        return TodoCardResponse.toTodoCardResponse(savedTodoCard)
    }

    @Transactional
    override fun deleteTodoCard(todoCardId: Long) {
        val savedTodoCard = todoCardRepository.findByIdOrNull(todoCardId) ?: throw ModelNotFoundException("TodoCard",todoCardId)
        todoCardRepository.deleteById(todoCardId)
    }


}
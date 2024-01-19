package com.teamsparta.todocards.domain.todocards.model

import com.teamsparta.todocards.domain.todocards.dto.UpdateTodoCardRequest
import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity
@Table(name = "todocard")
class TodoCard(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "createdat")
    var createdat: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH-mm")),

    @Column(name = "name")
    var name: String


    ) {

    fun updateTodocard(request: UpdateTodoCardRequest): Unit{
        if( request.content != null){
            request.content.also {this.content = it}
        }
        if( request.title != null){
            request.title.also{this.title = it}
        }
    }
}
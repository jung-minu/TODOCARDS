package com.teamsparta.todocards.domain.reply.model

import com.teamsparta.todocards.domain.todocards.model.TodoCard
import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Entity
class Reply(
    @Column(name = "content")
    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todoCard_id")
    var todoCard: TodoCard,
) {
    @Column(name = "created_at")
    var createdAt: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH-mm"))

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
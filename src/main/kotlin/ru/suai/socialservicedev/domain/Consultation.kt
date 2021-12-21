package ru.suai.socialservicedev.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "consultation")
data class Consultation(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @field:NotBlank(message = "title cannot be blank")
    @Column(name = "title")
    val title: String?,

    @field:NotBlank(message = "client name cannot be blank")
    @Column(name = "client_name")
    val clientName: String?,

    @field:NotBlank(message = "text cannot be blank")
    @Column(name = "txt")
    val txt: String?
)
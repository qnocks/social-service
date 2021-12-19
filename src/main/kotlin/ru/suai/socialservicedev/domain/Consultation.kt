package ru.suai.socialservicedev.domain

import javax.persistence.*

@Entity
@Table(name = "consultation")
data class Consultation(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val title: String,
    val clientName: String,
    val txt: String
)
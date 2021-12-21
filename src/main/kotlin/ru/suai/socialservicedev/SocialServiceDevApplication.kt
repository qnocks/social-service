package ru.suai.socialservicedev

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SocialServiceDevApplication

// TODO:
// 1. Validation +/-
// 2. Error handler +/-
// 3. Css

fun main(args: Array<String>) {
    runApplication<SocialServiceDevApplication>(*args)
}

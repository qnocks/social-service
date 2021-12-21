package ru.suai.socialservicedev.exception

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.ZonedDateTime

@ControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(e: MethodArgumentNotValidException): ResponseEntity<ApiException> {
        val message = e.bindingResult.fieldErrors[0].defaultMessage
        return ResponseEntity(
            ApiException(message, HttpStatus.BAD_REQUEST, ZonedDateTime.now()),
            HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun handleOrElseThrow(e: EmptyResultDataAccessException): ResponseEntity<ApiException> {
        return ResponseEntity(
            ApiException(e.message, HttpStatus.BAD_REQUEST, ZonedDateTime.now()),
            HttpStatus.BAD_REQUEST
        )
    }
}
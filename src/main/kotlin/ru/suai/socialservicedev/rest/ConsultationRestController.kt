package ru.suai.socialservicedev.rest

import org.springframework.web.bind.annotation.*
import ru.suai.socialservicedev.domain.Consultation
import ru.suai.socialservicedev.repository.ConsultationRepository

@RestController
@RequestMapping("api/v1/consultations")
class ConsultationRestController(private val consultationRepository: ConsultationRepository) {

    @GetMapping
    fun list(): List<Consultation>? {
        return consultationRepository.findAll() as List<Consultation>
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Long): Consultation {
        return consultationRepository.findById(id).orElse(null)
    }

    @PostMapping
    fun create(@RequestBody consultation :Consultation): Consultation {
        return consultationRepository.save(consultation)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        consultationRepository.deleteById(id)
    }
}
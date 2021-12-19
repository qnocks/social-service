package ru.suai.socialservicedev.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.suai.socialservicedev.domain.Consultation

@Repository
interface ConsultationRepository : CrudRepository<Consultation, Long> {
}
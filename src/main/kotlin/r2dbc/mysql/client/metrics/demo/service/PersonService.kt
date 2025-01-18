package r2dbc.mysql.client.metrics.demo.service

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.UUID

@Service
class PersonService(
    private val personRepository: PersonRepository,
) {
    @PostConstruct
    fun init() {
        Flux
            .fromIterable(
                (1..100).map {
                    val uuid = UUID.randomUUID().toString()
                    Person(id = null, uuid = uuid)
                },
            ).flatMap { person ->
                personRepository.save(person)
            }.subscribe()
    }
}

package nl.lunatech.repository.car

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import nl.lunatech.model.Car
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CarRepository: PanacheRepository<Car> {

    fun findByUUID(id: UUID?): Car? {
        // TODO: this random thingy should change
        return find("id", id ?: UUID.randomUUID()).firstResult()
    }
}
package nl.lunatech.service

import nl.lunatech.model.Car
import nl.lunatech.repository.CarRepository
import java.util.UUID
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class CarService {

    @Inject
    lateinit var carRepository: CarRepository

    fun getCarById(id: UUID): Car? {
        val response = carRepository.find("uuid", id)
        return response.firstResult()
    }
}
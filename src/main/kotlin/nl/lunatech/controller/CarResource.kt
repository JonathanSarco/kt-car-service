package nl.lunatech.controller

import nl.lunatech.model.Car
import nl.lunatech.repository.car.CarRepository
import java.util.*
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/car")
class CarResource {

    @Inject
    lateinit var carRepository: CarRepository

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getCarById(): Car? {
        // TODO: Random UUID to look for
        val response = carRepository.findByUUID(UUID.fromString("ecffc505-4ae3-485c-afc4-1bbad16c15cd"))
        println(response?.id)
        return response
    }


}
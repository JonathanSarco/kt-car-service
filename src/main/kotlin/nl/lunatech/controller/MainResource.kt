package nl.lunatech.controller

import nl.lunatech.model.Car
import nl.lunatech.model.City
import nl.lunatech.model.CityDistance
import nl.lunatech.service.CarService
import nl.lunatech.service.CityService
import org.jboss.resteasy.reactive.RestPath
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
class MainResource(
    val carService: CarService,
    val cityService: CityService
) {


//    val carService: CarService = CarService()
//    val cityService: CityService = CityService()

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/car/{id}")
    fun getCarById(@RestPath id: String): Car? {
        return carService.getCarById(UUID.fromString(id))
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cities")
    fun getAllCities(): List<City> {
        return cityService.getAllCities()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cities/distances")
    fun getAllDistances(): List<CityDistance> {
        return cityService.getAllDistances()
    }
}
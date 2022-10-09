package nl.lunatech.service

import nl.lunatech.model.City
import nl.lunatech.model.CityDistance
import nl.lunatech.repository.CityDistanceRepository
import nl.lunatech.repository.CityRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class CityService {

    @Inject
    lateinit var cityRepository: CityRepository

    @Inject
    lateinit var cityDistanceRepository: CityDistanceRepository

    fun getAllCities(): List<City> {
        return cityRepository.listAll()
    }

    fun getAllDistances(): List<CityDistance> {
        return cityDistanceRepository.listAll()
    }
}
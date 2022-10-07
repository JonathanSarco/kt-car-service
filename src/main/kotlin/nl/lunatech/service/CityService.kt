package nl.lunatech.service

import nl.lunatech.model.City
import nl.lunatech.model.CityDistance
import nl.lunatech.repository.CityDistanceRepository
import nl.lunatech.repository.CityRepository

class CityService {

    private val cityRepository: CityRepository = CityRepository()

    private val cityDistanceRepository: CityDistanceRepository = CityDistanceRepository()

    fun getAllCities(): List<City> {
        return cityRepository.listAll()
    }

    fun getAllDistances(): List<CityDistance> {
        return cityDistanceRepository.listAll()
    }
}
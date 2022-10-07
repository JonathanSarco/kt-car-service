package nl.lunatech.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import nl.lunatech.model.City
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CityRepository: PanacheRepository<City>
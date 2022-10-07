package nl.lunatech.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import nl.lunatech.model.CityDistance
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CityDistanceRepository: PanacheRepository<CityDistance>
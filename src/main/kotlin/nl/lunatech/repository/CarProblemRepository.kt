package nl.lunatech.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import nl.lunatech.model.CarProblem
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CarProblemRepository: PanacheRepository<CarProblem> {
}
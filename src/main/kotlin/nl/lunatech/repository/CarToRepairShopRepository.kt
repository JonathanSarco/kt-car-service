package nl.lunatech.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import nl.lunatech.model.CarToRepairShop
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CarToRepairShopRepository: PanacheRepository<CarToRepairShop> {
}
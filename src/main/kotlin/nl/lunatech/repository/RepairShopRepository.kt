package nl.lunatech.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import nl.lunatech.model.Car
import nl.lunatech.model.RepairShop
import java.util.*
import javax.enterprise.context.ApplicationScoped
import kotlin.collections.HashMap

@ApplicationScoped
class RepairShopRepository: PanacheRepository<RepairShop> {

//  val id: UUID,
//    val name: String,
//    val address: String,
//    val openingHour: String,
//    val closingHour: String,
//    val creationDate: String

//    private val repairShops: HashMap<UUID, RepairShop> = hashMapOf(
//        Pair(
//            UUID.fromString("e8c7615a-4e77-463a-a206-f614eb11f651"),
//            RepairShop(UUID.fromString("e8c7615a-4e77-463a-a206-f614eb11f651"), "RepairYou", "Coolsingel 55", "09:00", "18:00", "2021-10-10"),
//        )
//    )
}
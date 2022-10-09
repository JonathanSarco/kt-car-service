package nl.lunatech.model

import kotlinx.serialization.Serializable
import nl.lunatech.util.CustomSerializer
import java.util.UUID
import javax.persistence.*

@Entity
@Serializable
class CarToRepairShop {
    @Id
    @Serializable(with = CustomSerializer.UUIDSerializer::class)
    lateinit var id: UUID
    @Column(name = "repair_shop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var repairShop: RepairShop
    @Column(name = "car_id")
    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var car: Car
    @Column(name = "car_problem_id")
    @Serializable(with = CustomSerializer.UUIDSerializer::class)
    lateinit var carProblemId: UUID
    @Column(name = "registered_problem_date")
    lateinit var registeredProblemDate: String
}

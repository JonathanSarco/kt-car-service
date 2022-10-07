package nl.lunatech.model

import kotlinx.serialization.Serializable
import nl.lunatech.util.CustomSerializer
import java.time.LocalDate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id


class CarProblem(
    val id: UUID,
    val description: String,
    val partBroken: String,
    val brokenDate: LocalDate
)


//@Entity
//@Serializable
//class CarProblem {
//
//    @Id
//    @Serializable(with = CustomSerializer.UUIDSerializer::class)
//    lateinit var id: UUID
//
//    lateinit var description: String
//
//    @Column(name = "part_broken")
//    lateinit var partBroken: String
//
//    @Column(name = "broken_date")
//    lateinit var brokenDate: String
//}

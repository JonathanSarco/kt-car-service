package nl.lunatech.model

import kotlinx.serialization.Serializable
import nl.lunatech.util.CustomSerializer
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

//@Entity
//@Serializable
class RepairShop {

    @Id
    @Serializable(with = CustomSerializer.UUIDSerializer::class)
    lateinit var id: UUID

    lateinit var name: String

    lateinit var address: String

    @Column(name = "opening_hour")
    lateinit var openingHour: String

    @Column(name = "closing_hour")
    lateinit var closingHour: String

    @Column(name = "creation_date")
    lateinit var creationDate: String
}
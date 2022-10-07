package nl.lunatech.model

import kotlinx.serialization.Serializable
import nl.lunatech.util.CustomSerializer
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cities")
@Serializable
class City {
    @Id
    @Serializable(with = CustomSerializer.UUIDSerializer::class)
    lateinit var id: UUID
    lateinit var name: String
    lateinit var code: String
}
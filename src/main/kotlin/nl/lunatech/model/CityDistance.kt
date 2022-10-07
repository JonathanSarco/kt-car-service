package nl.lunatech.model

import kotlinx.serialization.Serializable
import nl.lunatech.util.CustomSerializer
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import kotlin.properties.Delegates

@Entity
@Table(name = "city_to_city")
@Serializable
class CityDistance {
    @Id
    @Serializable(with = CustomSerializer.UUIDSerializer::class)
    lateinit var id: UUID
    @Column(name = "from_city")
    lateinit var fromCity: String
    @Column(name = "to_city")
    lateinit var toCity: String
    var distance: Int = 0
}
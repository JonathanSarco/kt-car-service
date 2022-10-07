package nl.lunatech.model

import kotlinx.serialization.Serializable
import nl.lunatech.util.CustomSerializer
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "car")
@Serializable
class Car {
    @Id
    @Serializable(with = CustomSerializer.UUIDSerializer::class)
    lateinit var id: UUID
    lateinit var brand: String
    lateinit var model: String
    @Column(name = "licence_plate")
    lateinit var licencePlate: String
    @Column(name = "engine_model")
    lateinit var engineModel: String
    @Column(name = "engine_code")
    lateinit var engineCode: String
    @Column(name = "gearbox_type")
    lateinit var gearboxType: String
    lateinit var tyre: String
}

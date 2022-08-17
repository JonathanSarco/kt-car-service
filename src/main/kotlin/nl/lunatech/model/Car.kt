package nl.lunatech.model

import kotlinx.serialization.Serializable
import nl.lunatech.model.serializer.CarSerializer
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Serializable
class Car {

    @Id
    @Serializable(with = CarSerializer.UUIDSerializer::class)
    lateinit var id: UUID

    lateinit var brand: String

    lateinit var model: String

    @Column(name = "engine_model")
    lateinit var engineModel: String

    @Column(name = "engine_code")
    lateinit var engineCode: String

    lateinit var torque: String

    lateinit var power: String

    var co2: Int = 0

    @Column(name = "cx_s")
    lateinit var cxS: String

    lateinit var weight: String

    var displacement: Int = 0
    @Column(name = "block_material")

    lateinit var blockMaterial: String

    @Column(name = "gearbox_type")
    lateinit var gearboxType: String

    lateinit var tyre: String

    lateinit var others: String

    @Column(name = "traction_type")
    lateinit var tractionType: String
}

package nl.lunatech.serdes

import com.google.gson.GsonBuilder
import nl.lunatech.model.Car
import org.apache.kafka.common.serialization.Deserializer
import java.nio.charset.StandardCharsets

class CarDeserializer: Deserializer<Car> {

    private val gson = GsonBuilder().create()

    override fun deserialize(topic: String?, data: ByteArray?): Car {
        return gson.fromJson(data?.let { String(it, StandardCharsets.UTF_8) }, Car::class.java)
    }
}
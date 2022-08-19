package nl.lunatech.stream.serdes

import com.google.gson.GsonBuilder
import nl.lunatech.model.Car
import org.apache.kafka.common.serialization.Serializer
import java.nio.charset.StandardCharsets

class CarSerializer: Serializer<Car> {

    private val gson = GsonBuilder().create()

    override fun serialize(topic: String?, data: Car?): ByteArray {
        return gson.toJson(data).toByteArray(StandardCharsets.UTF_8)
    }
}
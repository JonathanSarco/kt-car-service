package nl.lunatech.stream.serdes

import nl.lunatech.model.Car
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serdes

class CustomSerDes {
    companion object {
        fun carSerDes(): Serde<Car> {
            val serializer = CarSerializer()
            val desSerializer = CarDeserializer()
            return Serdes.serdeFrom(serializer, desSerializer)
        }
    }
}
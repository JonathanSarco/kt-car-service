package nl.lunatech.stream.serdes

import com.google.gson.GsonBuilder
import nl.lunatech.stream.events.BrokenCarEvent
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.common.serialization.Serializer
import java.nio.charset.StandardCharsets

class BrokenCarSerdes {


    /**
     * Serializer
     */
    class BrokenCarSerializer: Serializer<BrokenCarEvent> {
        private val gson = GsonBuilder().create()

        override fun serialize(topic: String?, data: BrokenCarEvent?): ByteArray {
            return gson.toJson(data).toByteArray(StandardCharsets.UTF_8)
        }
    }

    /**
     * Deserializer
     */
    class BrokenCarDeserializer: Deserializer<BrokenCarEvent> {
        private val gson = GsonBuilder().create()

        override fun deserialize(topic: String?, data: ByteArray?): BrokenCarEvent {
            return gson.fromJson(data?.let { String(it, StandardCharsets.UTF_8) }, BrokenCarEvent::class.java)
        }
    }

    companion object {
        fun brokenCarEventSerde(): Serde<BrokenCarEvent> {
            return Serdes.serdeFrom(BrokenCarSerializer(), BrokenCarDeserializer())
        }
    }
}
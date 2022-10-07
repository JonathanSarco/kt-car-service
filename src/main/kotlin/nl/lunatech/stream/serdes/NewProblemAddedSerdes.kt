package nl.lunatech.stream.serdes

import com.google.gson.GsonBuilder
import nl.lunatech.stream.events.NewProblemAddedEvent
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.common.serialization.Serializer
import java.nio.charset.StandardCharsets

class NewProblemAddedSerdes {

    class NewProblemAddedSerializer: Serializer<NewProblemAddedEvent> {
        private val gson = GsonBuilder().create()

        override fun serialize(topic: String?, data: NewProblemAddedEvent?): ByteArray {
            return gson.toJson(data).toByteArray(StandardCharsets.UTF_8)
        }
    }

    class NewProblemAddedDeserializer: Deserializer<NewProblemAddedEvent> {
        private val gson = GsonBuilder().create()

        override fun deserialize(topic: String?, data: ByteArray?): NewProblemAddedEvent {
            return gson.fromJson(data?.let { String(it, StandardCharsets.UTF_8) }, NewProblemAddedEvent::class.java)
        }
    }

    companion object {
        fun newProblemAddedEventSerde(): Serde<NewProblemAddedEvent> {
            var serializer = NewProblemAddedSerializer()
            var deserializer = NewProblemAddedDeserializer()
            return Serdes.serdeFrom(serializer, deserializer)
        }
    }
}
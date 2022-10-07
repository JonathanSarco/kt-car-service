package nl.lunatech.config

import nl.lunatech.stream.serdes.BrokenCarSerdes
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.streams.StreamsConfig
import java.util.Properties

class StreamProperties {

    companion object {
        fun getSerializerProperties(): Properties {
            val props = Properties()
            props[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
            props["key.serializer"] = StringSerializer::class.java
            props["value.serializer"] = BrokenCarSerdes.BrokenCarSerializer::class.java
            return props
        }

        fun getDeserializerProperties(): Properties {
            val props = Properties()
            props[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
            props[StreamsConfig.APPLICATION_ID_CONFIG] = "kar-service-kafka"
            props["group.id"] = "hello-world"
            props["key.deserializer"] = BrokenCarSerdes.BrokenCarDeserializer::class.java
            props[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = StringDeserializer::class.java
            return props
        }
    }
}
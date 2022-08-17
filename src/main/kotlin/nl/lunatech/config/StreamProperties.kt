package nl.lunatech.config

import nl.lunatech.serdes.CarDeserializer
import nl.lunatech.serdes.CarSerializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.streams.StreamsConfig
import java.util.Properties

class StreamProperties {

    companion object {
        fun getSerializerProperties(): Properties {
            val props = Properties()
            props[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
            props[StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG] = StringSerializer::class.java
//            props["value.serializer"] = CarSerializer::class.java
            props[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = StringSerializer::class.java
            return props
        }

        fun getDeserializerProperties(): Properties {
            val props = Properties()
            props[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
            props[StreamsConfig.APPLICATION_ID_CONFIG] = "kar-service-kafka"
            props["group.id"] = "hello-world"
//            props["key.deserializer"] = StringDeserializer::class.java

            props[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = StringDeserializer::class.java
            return props
        }
    }
}
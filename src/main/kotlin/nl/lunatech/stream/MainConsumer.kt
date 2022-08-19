package nl.lunatech.stream

import nl.lunatech.config.StreamProperties
import nl.lunatech.util.Topic
import nl.lunatech.stream.RepairShopConsumer.Companion.initStream
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.Produced

class RepairShopConsumer {

    companion object {
        fun initStream() {
            val stringSerde = Serdes.String()
//            val carSerde = CustomSerDes.carSerDes()

            val builder = StreamsBuilder()

            builder
                .stream(Topic.CAR_BROKE_DOWN.topic, Consumed.with(stringSerde, stringSerde))
                .peek { key, value -> println("Observed event $value") }
                .to(Topic.REPAIR_SHOP_RECEIVED_CAR.topic, Produced.with(stringSerde, stringSerde))

            val topology = builder.build()
            val kafkaStreams = KafkaStreams(topology, StreamProperties.getDeserializerProperties())

            kafkaStreams.cleanUp()
            kafkaStreams.start()
        }
    }
}

fun main() {
//    initConsumer()
    initStream()
}

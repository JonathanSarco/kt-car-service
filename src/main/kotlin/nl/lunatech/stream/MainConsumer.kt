package nl.lunatech.stream

import nl.lunatech.config.StreamProperties
import nl.lunatech.util.Topic
import nl.lunatech.stream.RepairShopConsumer.Companion.initStream
import nl.lunatech.stream.events.BrokenCarEvent
import nl.lunatech.stream.serdes.BrokenCarSerdes
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed

class RepairShopConsumer {

//        @Id
//    @Serializable(with = CustomSerializer.UUIDSerializer::class)
//    lateinit var id: UUID
//    lateinit var description: String
//    @Column(name = "part_broken")
//    lateinit var partBroken: String
//    @Column(name = "broken_date")
//    lateinit var brokenDate: String

    companion object {
        private fun readBrokenCarEvent(value: BrokenCarEvent) {
            println("[Event]: ReadBrokenCar - $value")



        }


        fun initStream() {
            val stringSerde = Serdes.String()
            val brokenCarSerDes = BrokenCarSerdes.brokenCarEventSerde()

            val builder = StreamsBuilder()

            builder
                .stream(Topic.BROKEN_CAR_TOPIC.topic, Consumed.with(stringSerde, brokenCarSerDes))
                .peek { _, value -> readBrokenCarEvent(value) }

            val topology = builder.build()
            val kafkaStreams = KafkaStreams(topology, StreamProperties.getDeserializerProperties())

            kafkaStreams.cleanUp()
            kafkaStreams.start()
        }
    }
}

fun main() {
    initStream()
}

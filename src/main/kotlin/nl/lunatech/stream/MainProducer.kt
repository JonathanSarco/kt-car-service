package nl.lunatech.stream

import nl.lunatech.config.StreamProperties
import nl.lunatech.stream.BrokenCarProducer.Companion.produceEventBrokenCar
import nl.lunatech.util.Topic
import nl.lunatech.stream.events.BrokenCarEvent
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import java.time.LocalDate
import java.util.*


class BrokenCarProducer {

    companion object {
        private fun getProducer(): Producer<String, BrokenCarEvent> {
            return KafkaProducer(StreamProperties.getSerializerProperties())
        }

        fun produceEventBrokenCar(event: BrokenCarEvent) {
            val producer = getProducer()
            val future = producer.send(ProducerRecord(Topic.BROKEN_CAR_TOPIC.topic, "car-1", event))
            future.get()
            }
        }
}

fun main() {

    // Read car from DB
    val event = BrokenCarEvent(
        UUID.fromString("ad0b7439-9ae2-4cd3-948e-e1bdb2ba65c7"),
        "Engine is failing",
        LocalDate.now())

    produceEventBrokenCar(event)
}
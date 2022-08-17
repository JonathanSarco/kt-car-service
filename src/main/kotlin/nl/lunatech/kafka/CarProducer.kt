package nl.lunatech.kafka

import nl.lunatech.config.StreamProperties
import nl.lunatech.util.Topic
import nl.lunatech.kafka.CarProducer.Companion.initProducer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.streams.KafkaStreams

class CarProducer {

    companion object {
        private fun createProducer(): Producer<String, String> {
            return KafkaProducer(StreamProperties.getSerializerProperties())
        }

        fun initProducer() {
            val producer = createProducer()

            // var newCar = Car(UUID.randomUUID(), 2010, CarBrand.AUDI.name,"A3","1234", Engine(UUID.randomUUID(), "Audi"))
//            println("Producing: $newCar")
            val future = producer.send(ProducerRecord(Topic.CAR_BROKE_DOWN.topic, "car-1", "newCar"))
            future.get()
            }
        }
}

fun main() {
    for (i in 1..5) {
        initProducer()
    }

}
package nl.lunatech.util

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.*
import java.util.concurrent.Executors


class Util {
    val executorService = Executors.newFixedThreadPool(1)

    class Randomizer: AutoCloseable, Runnable {
        private var props: Properties
        private var topic: String
        private var closed: Boolean = false

        constructor(props: Properties, topic: String) {
            this.topic = topic;
            this.props = props;
            this.props.setProperty("client.id", "faker");
        }


        override fun close() {
            TODO("Not yet implemented")
        }

        override fun run() {
            TODO("Not yet implemented")
        }

//        override fun run() {
//            try {
//                KafkaProducer<String, String>(props).use { producer ->
//                    val faker = Faker()
//                    while (!closed) {
//                        try {
//                            val result: Any = producer.send(ProducerRecord(
//                                topic,
//                                faker.chuckNorris().fact())).get()
//                            Thread.sleep(5000)
//                        } catch (e: InterruptedException) {
//                        }
//                    }
//                }
//            } catch (ex: Exception) {
//                logger.error(ex.toString())
//            }
//        }

    }

}
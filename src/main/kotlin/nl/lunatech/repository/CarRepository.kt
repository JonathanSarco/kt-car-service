package nl.lunatech.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import nl.lunatech.model.Car
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CarRepository: PanacheRepository<Car>{

//    private val cars: HashMap<UUID, Car> = hashMapOf(
//        Pair(UUID.fromString("12c6671e-c687-405a-b8e6-40cd70853b7c"),
//            Car(UUID.fromString("12c6671e-c687-405a-b8e6-40cd70853b7c"), "Ferrari", "F1", "AAA111","E1", "EC1", "GB1", "T1")),
//        Pair(UUID.fromString("c4369184-b816-4ce6-86fb-65b846645dd1"),
//            Car(UUID.fromString("c4369184-b816-4ce6-86fb-65b846645dd1"), "Porsche", "GT1", "BBB222","P1", "PC1", "PB1", "T1")),
//        Pair(UUID.fromString("7ff65771-7f2e-4447-a172-9a4c90abceb2"),
//            Car(UUID.fromString("7ff65771-7f2e-4447-a172-9a4c90abceb2"), "Porsche", "GT2", "CCC333","P2", "PC2", "PB1", "T2")),
//        Pair(UUID.fromString("3ba9eeae-e8f8-467f-aa77-8532b4d7275a"),
//            Car(UUID.fromString("3ba9eeae-e8f8-467f-aa77-8532b4d7275a"), "Mercedes", "M1", "DDD444", "M1", "M2", "MB1", "T3")),
//        Pair(UUID.fromString("06ede9dd-3bd6-48d8-9a5b-61e6c613f83c"),
//            Car(UUID.fromString("06ede9dd-3bd6-48d8-9a5b-61e6c613f83c"), "Mercedes", "M1", "EEE555", "M2", "M2", "MB2", "T2")),
//        Pair(UUID.fromString("ce554d88-82d7-4a1f-90e0-e3adc81e35a6"),
//            Car(UUID.fromString("ce554d88-82d7-4a1f-90e0-e3adc81e35a6"), "Ford", "F1", "FFF6666", "F1", "FC1", "FB1", "T1"))
//    )

    fun findCarsByAttribute(attr: String, param: String): Set<Car> {
        return list(attr, param).toSet()
    }
}
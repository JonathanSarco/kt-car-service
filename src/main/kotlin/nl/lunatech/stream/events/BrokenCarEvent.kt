package nl.lunatech.stream.events

import java.time.LocalDate
import java.util.UUID

data class BrokenCarEvent(
    val carId: UUID,
    val problemDescription: String,
    val brokenDate: LocalDate
)
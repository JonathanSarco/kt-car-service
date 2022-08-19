package nl.lunatech.stream.events

import java.util.UUID

data class NewProblemAddedEvent(
    val problemId: UUID,
    val carId: UUID)
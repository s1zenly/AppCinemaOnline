package ru.hse.sema.homework.backend.model.data

import ru.hse.sema.homework.backend.model.`interface`.IBuyTicket
import java.time.LocalDateTime
import kotlin.time.Duration

data class Ticket(
    private val movieName: String,
    private val date: LocalDateTime,
    private val duration: Double,
    private val row: Int,
    private val place: Int
) : IBuyTicket {

    private val seat: Pair<Int, Int> = Pair(row, place)

    override var sold: Boolean = false

    val getMovieName: String
        get() = movieName

    val getDate: LocalDateTime
        get() = date

    val getDuration: Double
        get() = duration

    val getSeat: Pair<Int, Int>
        get() = seat

    override fun toString(): String {
        val sepDate = date.toString().split("T")
        return "Movie: ${movieName}\n" +
                "Date: ${sepDate[0]} ${sepDate[1]}\n" +
                "Duration: ${duration}\n" +
                "Row: ${row}\n" +
                "Place: ${place}\n"
    }

    override fun equals(other: Any?): Boolean {
        val entity = other as Ticket
        return this.getMovieName == entity.getMovieName &&
                this.getDate == entity.getDate &&
                this.getDuration == entity.getDuration &&
                this.getSeat.first == entity.getSeat.first &&
                this.getSeat.second == entity.getSeat.second
    }
}
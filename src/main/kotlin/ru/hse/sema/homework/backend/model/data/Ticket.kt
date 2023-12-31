package ru.hse.sema.homework.backend.model.data

import com.fasterxml.jackson.annotation.JsonIgnore
import ru.hse.sema.homework.backend.model.interfaces.IBuyTicket
import java.time.LocalDateTime

data class Ticket(
    val movieName: String,
    val date: LocalDateTime,
    val duration: Int,
    @JsonIgnore val row: Int,
    @JsonIgnore val place: Int
) : IBuyTicket {

    val seat: Pair<Int, Int> = Pair(row, place)

    @JsonIgnore override var sold: Boolean = false


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
        return this.movieName == entity.movieName &&
                this.date == entity.date &&
                this.duration == entity.duration &&
                this.seat.first == entity.seat.first &&
                this.seat.second == entity.seat.second
    }
}
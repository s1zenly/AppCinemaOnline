package ru.hse.sema.homework.backend.model.data

import com.fasterxml.jackson.annotation.JsonIgnore
import globalData
import ru.hse.sema.homework.backend.model.`interface`.ISessionActive
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class Session(
    val movie: Movie,
    val date: LocalDateTime,

) : ISessionActive {

    @JsonIgnore val ticketList: MutableList<Ticket> = mutableListOf()
    @JsonIgnore val cinemaHall: CinemaHall = CinemaHall(globalData.getLength, globalData.getWidth)

    @JsonIgnore override var started: Boolean = false


    @JsonIgnore fun getTimeEnd(): LocalDateTime {
        return date.plusHours((movie.duration / 1).toLong()).plusMinutes((movie.duration % 1 * 100).toLong())
    }

    override fun toString(): String {
        return "movie: ${movie.name}\n" +
                "date: ${date.format(globalData.formatterDateTime)}\n"
    }

    override fun equals(other: Any?): Boolean {
        val entity = other as Session
        return this.movie == entity.movie &&
                this.date == entity.date
    }
}
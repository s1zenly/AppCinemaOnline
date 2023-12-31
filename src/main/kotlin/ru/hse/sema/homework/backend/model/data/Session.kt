package ru.hse.sema.homework.backend.model.data

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import globalData
import ru.hse.sema.homework.backend.model.interfaces.ISessionActive
import java.time.LocalDateTime


data class Session(
    val movie: Movie,
    @get:JsonProperty("start_time") val date: LocalDateTime,

) : ISessionActive {

    @JsonIgnore val ticketList: MutableList<Ticket> = mutableListOf()
    @JsonIgnore val cinemaHall: CinemaHall = CinemaHall(globalData.getLength, globalData.getWidth)

    @JsonIgnore override var started: Boolean = false


    @JsonGetter("end_time") fun getTimeEnd(): LocalDateTime {
        return date.plusHours((movie.duration / 60).toLong()).plusMinutes((movie.duration % 60).toLong())
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
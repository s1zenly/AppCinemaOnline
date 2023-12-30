package ru.hse.sema.homework.backend.model.data

import globalData
import ru.hse.sema.homework.backend.model.`interface`.ISessionActive
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class Session(
    private val movie: Movie,
    private val date: LocalDateTime,

) : ISessionActive {

    private val ticketList: MutableList<Ticket> = mutableListOf()
    private val cinemaHall: CinemaHall = CinemaHall(globalData.getLength, globalData.getWidth)

    override var started: Boolean = false

    val getCinemaHall: CinemaHall
        get() = cinemaHall

    val getDate: LocalDateTime
        get() = date

    val getMovie: Movie
        get() = movie

    val getTicketList: MutableList<Ticket>
        get() = ticketList


    fun getTimeEnd(): LocalDateTime {
        return date.plusHours((movie.getDuration / 1).toLong()).plusMinutes((movie.getDuration % 1 * 100).toLong())
    }

    override fun toString(): String {
        return "movie: ${movie.getName}\n" +
                "date: ${date.format(globalData.getFormatterDateTime)}\n"
    }

    override fun equals(other: Any?): Boolean {
        val entity = other as Session
        return this.getMovie == entity.getMovie &&
                this.getDate == entity.getDate
    }
}
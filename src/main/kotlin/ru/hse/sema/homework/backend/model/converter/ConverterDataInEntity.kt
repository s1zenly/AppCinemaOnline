package ru.hse.sema.homework.backend.model.converter

import exсeptions.IncorrectExistenceFilm
import globalData
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.Movie
import ru.hse.sema.homework.backend.model.data.Session
import ru.hse.sema.homework.backend.model.data.Ticket
import java.time.LocalDateTime


/**
 * Converts a list of data into an object
 */
object ConverterDataInEntity {

    fun getCorrectTicket(list: List<String?>): Ticket {
        val(name, date, duration, row, place) = list
        val cinemaHall = Pair(row!!.toInt(), place!!.toInt())

        return Ticket(name!!, LocalDateTime.parse(date, globalData.formatterDateTime),
            duration!!.toInt(), cinemaHall.first, cinemaHall.second)
    }

    fun getCorrectSession(list: List<String?>): Any {
        val(name, date) = list

        val movie = backendGlobalData.databaseFilms.getListFilmsRead.filter { it.name == name }.firstOrNull()

        try {
            if(movie == null) throw IncorrectExistenceFilm()
        } catch (e: IncorrectExistenceFilm) {
            return e.message
        }

        return Session(movie, LocalDateTime.parse(date, globalData.formatterDateTime))
    }

    fun getCorrectMovie(list: List<String?>): Movie {
        val(name, style, duration, info) = list

        return Movie(name!!, style!!, duration!!.toInt(), info)
    }

}
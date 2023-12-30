package ru.hse.sema.homework.backend.handler

import actionsCinema.ActionsCinema
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.Session

object CinemaHandler {

    fun ticketRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        val ticket = backendGlobalData.getConverterDataInEntity.getCorrectTicket(data)

        val answerManager = when(action) {
            ActionsCinema.BUY_TICKET -> backendGlobalData.getTicketManager.addTicket(ticket)
            ActionsCinema.RETURN_TICKET -> backendGlobalData.getTicketManager.removeTicket(ticket)
            ActionsCinema.MARK_CUSTOMER -> backendGlobalData.getTicketManager.markCustomer(ticket)

            else -> TODO()
        }

        return answerManager
    }

    fun sessionRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        var session: Any? = null
        var sessionFirst: Any? = null
        var sessionSecond: Any? = null

        if(action == ActionsCinema.CHANGE_SESSION) {
            sessionFirst = backendGlobalData.getConverterDataInEntity.getCorrectSession(data.subList(0, data.size / 2))
            sessionSecond = backendGlobalData.getConverterDataInEntity.getCorrectSession(data.subList(data.size / 2, data.size))
            if(sessionFirst is String) return Pair(null, sessionFirst.toString())
            if(sessionSecond is String) return Pair(null, sessionSecond.toString())

        } else {
            session = backendGlobalData.getConverterDataInEntity.getCorrectSession(data)
            if(session is String) return Pair(null, session.toString())
        }

        val answerManager = when(action) {
            ActionsCinema.ADD_SESSION -> backendGlobalData.getSessionManager.createSession(session as Session)
            ActionsCinema.REMOVE_SESSION -> backendGlobalData.getSessionManager.deleteSession(session as Session)
            ActionsCinema.CHANGE_SESSION -> backendGlobalData.getSessionManager.changeSession(sessionFirst as Session, sessionSecond as Session)

            else -> TODO()
        }


        return answerManager
    }

    fun movieRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        val movie = backendGlobalData.getConverterDataInEntity.getCorrectMovie(data)

        val answerManager = when(action) {
            ActionsCinema.ADD_FILM -> backendGlobalData.getMovieManager.addFilms(movie)
            ActionsCinema.REMOVE_FILM -> backendGlobalData.getMovieManager.deleteFilms(movie)

            else -> TODO()
        }

        return answerManager
    }

    fun cinemaHallRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        var session = backendGlobalData.getConverterDataInEntity.getCorrectSession(data)

        if(session is String) return Pair(null, session.toString())

        session = backendGlobalData.getDatabaseSessions.getListSessionRead.filter { it == session }.first()

        val answerManager = when(action) {
            ActionsCinema.DISPLAY_HALL -> backendGlobalData.getCinemaHallManager.displayHall(session)

            else -> TODO()
        }

        return answerManager
    }

    fun databaseRequest(action: ActionsCinema, data: List<String?>?): Pair<Any?, String?> {
        val answerManager = when(action) {
            ActionsCinema.GET_LIST_SESSIONS -> backendGlobalData.getDatabaseManager.getListSession()
            ActionsCinema.GET_LIST_MOVIES -> backendGlobalData.getDatabaseManager.getListMovies()
            ActionsCinema.GET_LIST_TICKETS -> {
                var session = backendGlobalData.getConverterDataInEntity.getCorrectSession(data!!)

                if(session is String) return Pair(null, session.toString())

                session = backendGlobalData.getDatabaseSessions.getListSessionRead.filter { it.equals(session) }.first()

                backendGlobalData.getDatabaseManager.getListTickets(session)
            }

            else -> TODO()
        }

        return answerManager
    }

}
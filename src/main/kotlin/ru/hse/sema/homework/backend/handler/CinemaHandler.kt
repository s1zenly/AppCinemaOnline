package ru.hse.sema.homework.backend.handler

import actionsCinema.ActionsCinema
import exсeptions.IncorrectDatabaseIsEmpty
import exсeptions.IncorrectExistenceSession
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.Session

object CinemaHandler {

    fun ticketRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        val ticket = backendGlobalData.converterDataInEntity.getCorrectTicket(data)

        val answerManager = when(action) {
            ActionsCinema.BUY_TICKET -> backendGlobalData.ticketManager.addTicket(ticket)
            ActionsCinema.RETURN_TICKET -> backendGlobalData.ticketManager.removeTicket(ticket)
            ActionsCinema.MARK_CUSTOMER -> backendGlobalData.ticketManager.markCustomer(ticket)

            else -> TODO()
        }

        return answerManager
    }

    fun sessionRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        var session: Any? = null
        var sessionFirst: Any? = null
        var sessionSecond: Any? = null

        if(action == ActionsCinema.CHANGE_SESSION) {
            sessionFirst = backendGlobalData.converterDataInEntity.getCorrectSession(data.subList(0, data.size / 2))
            sessionSecond = backendGlobalData.converterDataInEntity.getCorrectSession(data.subList(data.size / 2, data.size))
            if(sessionFirst is String) return Pair(null, sessionFirst.toString())
            if(sessionSecond is String) return Pair(null, sessionSecond.toString())

            try {
                if(backendGlobalData.databaseSessions.getListSessionRead.isEmpty()) throw IncorrectDatabaseIsEmpty()
                if(backendGlobalData.databaseSessions.getListSessionRead.filter { it == sessionFirst }.firstOrNull() == null) throw IncorrectExistenceSession()
            } catch (e: IncorrectDatabaseIsEmpty) {
                return Pair(null, e.message)
            } catch (e: IncorrectExistenceSession) {
                return Pair(null, e.message)
            }

        } else {
            session = backendGlobalData.converterDataInEntity.getCorrectSession(data)
            if(session is String) return Pair(null, session.toString())
        }

        val answerManager = when(action) {
            ActionsCinema.ADD_SESSION -> backendGlobalData.sessionManager.createSession(session as Session)
            ActionsCinema.REMOVE_SESSION -> backendGlobalData.sessionManager.deleteSession(session as Session)
            ActionsCinema.CHANGE_SESSION -> backendGlobalData.sessionManager.changeSession(sessionFirst as Session, sessionSecond as Session)

            else -> TODO()
        }


        return answerManager
    }

    fun movieRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        val movie = backendGlobalData.converterDataInEntity.getCorrectMovie(data)

        val answerManager = when(action) {
            ActionsCinema.ADD_FILM -> backendGlobalData.movieManager.addFilms(movie)
            ActionsCinema.REMOVE_FILM -> backendGlobalData.movieManager.deleteFilms(movie)

            else -> TODO()
        }

        return answerManager
    }

    fun cinemaHallRequest(action: ActionsCinema, data: List<String?>): Pair<Any?, String?> {
        var session = backendGlobalData.converterDataInEntity.getCorrectSession(data)

        if(session is String) return Pair(null, session.toString())

        session = backendGlobalData.databaseSessions.getListSessionRead.filter { it == session }.first()

        val answerManager = when(action) {
            ActionsCinema.DISPLAY_HALL -> backendGlobalData.cinemaHallManager.displayHall(session)

            else -> TODO()
        }

        return answerManager
    }

    fun databaseRequest(action: ActionsCinema, data: List<String?>?): Pair<Any?, String?> {
        val answerManager = when(action) {
            ActionsCinema.GET_LIST_SESSIONS -> backendGlobalData.databaseManager.getListSession()
            ActionsCinema.GET_LIST_MOVIES -> backendGlobalData.databaseManager.getListMovies()
            ActionsCinema.GET_LIST_TICKETS -> {

                var session = backendGlobalData.converterDataInEntity.getCorrectSession(data!!)

                if(session is String) return Pair(null, session.toString())

                if(backendGlobalData.databaseFilms.getListFilmsRead.isEmpty()) {
                    try {
                        throw IncorrectDatabaseIsEmpty()
                    } catch (e: IncorrectDatabaseIsEmpty) {
                        return Pair(null, e.message)
                    }
                }

                session = backendGlobalData.databaseSessions.getListSessionRead.filter { it.equals(session) }.first()

                backendGlobalData.databaseManager.getListTickets(session)
            }

            else -> TODO()
        }

        return answerManager
    }

}
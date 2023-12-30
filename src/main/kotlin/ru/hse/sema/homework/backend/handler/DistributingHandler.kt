package ru.hse.sema.homework.backend.handler

import actionsCinema.ActionsCinema
import ru.hse.sema.homework.backend.backendGlobalData

object DistributingHandler {

    fun distributingRequest(action: ActionsCinema, data: List<String?>?): Pair<Any?, String?> {
        val result = when(action) {
            ActionsCinema.BUY_TICKET,
            ActionsCinema.RETURN_TICKET,
            ActionsCinema.MARK_CUSTOMER -> backendGlobalData.getCinemaHandler.ticketRequest(action, data!!)

            ActionsCinema.ADD_FILM,
            ActionsCinema.REMOVE_FILM,-> backendGlobalData.getCinemaHandler.movieRequest(action, data!!)

            ActionsCinema.ADD_SESSION,
            ActionsCinema.REMOVE_SESSION,
            ActionsCinema.CHANGE_SESSION -> backendGlobalData.getCinemaHandler.sessionRequest(action, data!!)

            ActionsCinema.GET_LIST_SESSIONS,
            ActionsCinema.GET_LIST_MOVIES,
            ActionsCinema.GET_LIST_TICKETS -> backendGlobalData.getCinemaHandler.databaseRequest(action, data)

            ActionsCinema.DISPLAY_HALL -> backendGlobalData.getCinemaHandler.cinemaHallRequest(action, data!!)

        }

        return result
    }
}
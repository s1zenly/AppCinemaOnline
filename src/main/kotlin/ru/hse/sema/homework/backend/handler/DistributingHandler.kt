package ru.hse.sema.homework.backend.handler

import actions.ActionsCinema
import actions.ActionsSystem
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.interfaces.IThreadRun

/**
 * Global backend handler
 */
object DistributingHandler : IThreadRun {

    override var isRunning: Boolean = false

    fun distributingRequest(action: ActionsCinema, data: List<String?>?): Pair<Any?, String?> {
        runDaemonThreads()
        val result = when(action) {
            ActionsCinema.BUY_TICKET,
            ActionsCinema.RETURN_TICKET,
            ActionsCinema.MARK_CUSTOMER -> backendGlobalData.cinemaHandler.ticketRequest(action, data!!)

            ActionsCinema.ADD_FILM,
            ActionsCinema.REMOVE_FILM,-> backendGlobalData.cinemaHandler.movieRequest(action, data!!)

            ActionsCinema.ADD_SESSION,
            ActionsCinema.REMOVE_SESSION,
            ActionsCinema.CHANGE_SESSION -> backendGlobalData.cinemaHandler.sessionRequest(action, data!!)

            ActionsCinema.GET_LIST_SESSIONS,
            ActionsCinema.GET_LIST_MOVIES,
            ActionsCinema.GET_LIST_TICKETS -> backendGlobalData.cinemaHandler.databaseRequest(action, data)

            ActionsCinema.DISPLAY_HALL -> backendGlobalData.cinemaHandler.cinemaHallRequest(action, data!!)

        }

        return result
    }

    fun systemRequest(action: ActionsSystem) {
        when(action) {
            ActionsSystem.DELETE_FILES -> backendGlobalData.systemHandler.deleteFilesRequest()
        }
    }

    private fun runDaemonThreads() {
        if(!isRunning) backendGlobalData.daemonThreadManager.start()
    }
}
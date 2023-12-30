package ru.hse.sema.homework.fronted.handler

import ru.hse.sema.homework.fronted.frontedGlobalDate
import actionsCinema.ActionsCinema
import globalData
import performCommand

object CustomerHandler {

    fun ticketHandler(action: ActionsCinema) {
        val ticket = frontedGlobalDate.getClientInfoReader.ticketReader()
        val messageCorrectTicket = frontedGlobalDate.getCheckerCorrectData.isCorrectTicket(ticket)

        if(messageCorrectTicket != null) {
            frontedGlobalDate.getViewResult.view(null, messageCorrectTicket)
        } else {

            val result = frontedGlobalDate.getDistributingHandler.distributingRequest(action, ticket)

            if(result.second != null) {
                frontedGlobalDate.getViewResult.view(null, result.second)
            } else {
                frontedGlobalDate.getViewResult.view(action, result.first)
            }
        }
    }

    fun sessionHandler(action: ActionsCinema) {
        var session: List<String?> = listOf()

        val sessionFirst = frontedGlobalDate.getClientInfoReader.sessionReader()
        val messageCorrectSessionFirst = frontedGlobalDate.getCheckerCorrectData.isCorrectSession(sessionFirst)
        var sessionSecond: List<String?> = listOf()
        var messageCorrectSessionSecond: String? = null

        if(action == ActionsCinema.CHANGE_SESSION) {
            sessionSecond = frontedGlobalDate.getClientInfoReader.sessionReader()
            messageCorrectSessionSecond = frontedGlobalDate.getCheckerCorrectData.isCorrectSession(sessionSecond)
        }

        session = sessionFirst + sessionSecond

        if(messageCorrectSessionFirst != null) {
            frontedGlobalDate.getViewResult.view(null, messageCorrectSessionFirst)
        } else if(messageCorrectSessionSecond != null) {
            frontedGlobalDate.getViewResult.view(null, messageCorrectSessionSecond)
        } else {

            val result = frontedGlobalDate.getDistributingHandler.distributingRequest(action, session)

            if(result.second != null) {
                frontedGlobalDate.getViewResult.view(null, result.second)
            } else {
                frontedGlobalDate.getViewResult.view(action, result.first)
            }

        }
    }

    fun movieHandler(action: ActionsCinema) {
        val movie = frontedGlobalDate.getClientInfoReader.movieReader()
        val messageCorrectMovie = frontedGlobalDate.getCheckerCorrectData.isCorrectMovie(movie)

        if(messageCorrectMovie != null) {
            frontedGlobalDate.getViewResult.view(null, messageCorrectMovie)
        } else {

            val result = frontedGlobalDate.getDistributingHandler.distributingRequest(action, movie)

            if(result.second != null) {
                frontedGlobalDate.getViewResult.view(null, result.second)
            } else {
                frontedGlobalDate.getViewResult.view(action, result.first)
            }
        }
    }

    fun databaseInfoHandler(action: ActionsCinema) {

        val result = frontedGlobalDate.getDistributingHandler.distributingRequest(action, null)

        if(result.second != null) {
            frontedGlobalDate.getViewResult.view(null, result.second)
        } else {
            frontedGlobalDate.getViewResult.view(action, result.first)
        }
    }




    fun cinemaHallHandler(): Pair<Int, Int>? {
        val size = frontedGlobalDate.getClientInfoReader.cinemaHallReader()
        val messageCorrectSize = frontedGlobalDate.getCheckerCorrectData.isCorrectCinemaHall(size)

        if(messageCorrectSize != null) {
            frontedGlobalDate.getViewResult.view(null, messageCorrectSize)
        } else {
            return frontedGlobalDate.getConverterData.getCorrectCinemaHall(size)
        }

        return null
    }

    fun menuHandler() {
        frontedGlobalDate.getViewMenuCapabilities.view()
    }

    fun commandHandler() {
        val command = frontedGlobalDate.getClientInfoReader.commandReader()
        val messageCorrectCommand = frontedGlobalDate.getCheckerCorrectData.isCorrectCommand(command)

        if(messageCorrectCommand != null) {
            frontedGlobalDate.getViewResult.view(null, messageCorrectCommand)
        } else {
            performCommand(frontedGlobalDate.getConverterData.getCorrectCommand(command))
        }
    }

}
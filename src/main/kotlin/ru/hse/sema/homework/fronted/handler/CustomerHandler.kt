package ru.hse.sema.homework.fronted.handler

import ru.hse.sema.homework.fronted.frontedGlobalDate
import actionsCinema.ActionsCinema
import globalData
import performCommand

object CustomerHandler {

    fun ticketHandler(action: ActionsCinema) {
        val ticket = frontedGlobalDate.clientInfoReader.ticketReader()
        val messageCorrectTicket = frontedGlobalDate.checkerCorrectData.isCorrectTicket(ticket)

        if(messageCorrectTicket != null) {
            frontedGlobalDate.viewResult.view(null, messageCorrectTicket)
        } else {

            val result = frontedGlobalDate.distributingHandler.distributingRequest(action, ticket)

            if(result.second != null) {
                frontedGlobalDate.viewResult.view(null, result.second)
            } else {
                frontedGlobalDate.viewResult.view(action, result.first)
            }
        }
    }

    fun sessionHandler(action: ActionsCinema) {
        var session: List<String?> = listOf()

        val sessionFirst = frontedGlobalDate.clientInfoReader.sessionReader()
        val messageCorrectSessionFirst = frontedGlobalDate.checkerCorrectData.isCorrectSession(sessionFirst)
        var sessionSecond: List<String?> = listOf()
        var messageCorrectSessionSecond: String? = null

        if(action == ActionsCinema.CHANGE_SESSION) {
            sessionSecond = frontedGlobalDate.clientInfoReader.sessionReader()
            messageCorrectSessionSecond = frontedGlobalDate.checkerCorrectData.isCorrectSession(sessionSecond)
        }

        session = sessionFirst + sessionSecond

        if(messageCorrectSessionFirst != null) {
            frontedGlobalDate.viewResult.view(null, messageCorrectSessionFirst)
        } else if(messageCorrectSessionSecond != null) {
            frontedGlobalDate.viewResult.view(null, messageCorrectSessionSecond)
        } else {

            val result = frontedGlobalDate.distributingHandler.distributingRequest(action, session)

            if(result.second != null) {
                frontedGlobalDate.viewResult.view(null, result.second)
            } else {
                frontedGlobalDate.viewResult.view(action, result.first)
            }

        }
    }

    fun movieHandler(action: ActionsCinema) {
        val movie = frontedGlobalDate.clientInfoReader.movieReader()
        val messageCorrectMovie = frontedGlobalDate.checkerCorrectData.isCorrectMovie(movie)

        if(messageCorrectMovie != null) {
            frontedGlobalDate.viewResult.view(null, messageCorrectMovie)
        } else {

            val result = frontedGlobalDate.distributingHandler.distributingRequest(action, movie)

            if(result.second != null) {
                frontedGlobalDate.viewResult.view(null, result.second)
            } else {
                frontedGlobalDate.viewResult.view(action, result.first)
            }
        }
    }

    fun databaseInfoHandler(action: ActionsCinema) {

        val result = frontedGlobalDate.distributingHandler.distributingRequest(action, null)

        if(result.second != null) {
            frontedGlobalDate.viewResult.view(null, result.second)
        } else {
            frontedGlobalDate.viewResult.view(action, result.first)
        }
    }




    fun cinemaHallHandler(): Pair<Int, Int>? {
        val size = frontedGlobalDate.clientInfoReader.cinemaHallReader()
        val messageCorrectSize = frontedGlobalDate.checkerCorrectData.isCorrectCinemaHall(size)

        if(messageCorrectSize != null) {
            frontedGlobalDate.viewResult.view(null, messageCorrectSize)
        } else {
            return frontedGlobalDate.converterData.getCorrectCinemaHall(size)
        }

        return null
    }

    fun menuHandler() {
        frontedGlobalDate.viewMenuCapabilities.view()
    }

    fun commandHandler() {
        val command = frontedGlobalDate.clientInfoReader.commandReader()
        val messageCorrectCommand = frontedGlobalDate.checkerCorrectData.isCorrectCommand(command)

        if(messageCorrectCommand != null) {
            frontedGlobalDate.viewResult.view(null, messageCorrectCommand)
        } else {
            performCommand(frontedGlobalDate.converterData.getCorrectCommand(command))
        }
    }

}
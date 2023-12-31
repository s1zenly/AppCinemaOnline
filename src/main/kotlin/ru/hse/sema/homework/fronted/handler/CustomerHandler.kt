package ru.hse.sema.homework.fronted.handler

import ru.hse.sema.homework.fronted.frontedGlobalDate
import performCommand

/**
 * Singleton class which sends it to the model for processing and returns the result
 */
object CustomerHandler {

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
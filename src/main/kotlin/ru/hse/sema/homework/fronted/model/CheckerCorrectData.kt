package ru.hse.sema.homework.fronted.model

import exсeptions.*
import globalData
import java.time.LocalDateTime
import java.time.format.DateTimeParseException


/**
 * Singleton class which verifies the correctness of the input data
 *
 * functions returns message about error. If message == null -> There are no mistakes
 */
object CheckerCorrectData {

    fun isCorrectTicket(list: List<String?>): String?  {
        val(name, date, duration, row, place) = list

        val messageExceptionNameMovieValue = checkCorrectNameMovie(name)
        val messageExceptionDateMovieValue = checkCorrectFormatDate(date)
        val messageExceptionDurationValue = checkCorrectDuration(duration)
        val messageExceptionRowValue = checkCorrectRow(row)
        val messageExceptionPlaceValue = checkCorrectPlace(place)

        if(messageExceptionNameMovieValue != null) return messageExceptionNameMovieValue
        if(messageExceptionDateMovieValue != null) return messageExceptionDateMovieValue
        if(messageExceptionDurationValue != null) return messageExceptionDurationValue
        if(messageExceptionRowValue != null) return messageExceptionRowValue
        if(messageExceptionPlaceValue != null) return messageExceptionPlaceValue

        return null
    }

    fun isCorrectSession(list: List<String?>): String? {
        val(name, date) = list

        val messageExceptionNameMovieValue = checkCorrectNameMovie(name)
        val messageExceptionDateMovieValue = checkCorrectFormatDate(date)

        if(messageExceptionNameMovieValue != null) return messageExceptionNameMovieValue
        if(messageExceptionDateMovieValue != null) return messageExceptionDateMovieValue

        return null
    }

    fun isCorrectMovie(list: List<String?>): String? {
        val(name, style, duration, info) = list

        val messageExceptionNameMovieValue = checkCorrectNameMovie(name)
        val messageExceptionStyleValue = checkCorrectStyle(style)
        val messageExceptionDurationValue = checkCorrectDuration(duration)

        if(messageExceptionNameMovieValue != null) return messageExceptionNameMovieValue
        if(messageExceptionStyleValue != null) return messageExceptionStyleValue
        if(messageExceptionDurationValue != null) return messageExceptionDurationValue

        return null
    }

    fun isCorrectCinemaHall(list: List<String?>): String? {
        val(row, place) = list

        val messageExceptionRowValue = checkCorrectRow(row)
        val messageExceptionPlaceValue = checkCorrectPlace(place)

        if(messageExceptionRowValue != null) return messageExceptionRowValue
        if(messageExceptionPlaceValue != null) return messageExceptionPlaceValue

        return null
    }

    fun isCorrectCommand(command: String?): String? {

        val messageCorrectCommand = checkCorrectCommand(command)

        if(messageCorrectCommand != null) return messageCorrectCommand

        return null
    }


    private fun checkCorrectNameMovie(name: String?): String? {
        val nameCorrect = try {
            if(name == "") {
                throw IncorrectNameMovie()
            }
            null
        } catch (e: IncorrectNameMovie) {
            e.message
        }

        return nameCorrect
    }

    private fun checkCorrectFormatDate(date: String?): String? {
        val dataTimeCorrect = try {
            LocalDateTime.parse(date, globalData.formatterDateTime)
            null
        } catch (e: DateTimeParseException) {
            globalData.COLOR_RED_HEAD + "Incorrect time format\n" + globalData.COLOR_TAIL
        }

        return dataTimeCorrect
    }

    private fun checkCorrectDuration(duration: String?): String? {
        val durationCorrect = try {
            if(duration?.toIntOrNull() == null || duration.toInt() <= 0) {
                throw IncorrectFormatDuration()
            }
            null
        } catch (e: IncorrectFormatDuration) {
            e.message
        }

        return durationCorrect
    }

    private fun checkCorrectRow(row: String?): String? {
        val rowCorrect = try {
            if(row?.toIntOrNull() == null || row.toInt() <= 0 ) {
                throw IncorrectRowCinema()
            }
            if(globalData.getLength != 0 && globalData.getLength < row.toInt()) {
                throw IncorrectInputRowCinema()
            }
            null
        } catch (e: IncorrectRowCinema) {
            e.message
        } catch (e: IncorrectInputRowCinema) {
            e.message
        }

        return rowCorrect
    }

    private fun checkCorrectPlace(place: String?): String? {
        val placeCorrect = try {
            if(place?.toIntOrNull() == null || place.toInt() <= 0 ) {
                throw IncorrectPlaceCinema()
            }
            if(globalData.getWidth != 0 && globalData.getWidth < place.toInt()) {
                throw IncorrectInputPlaceCinema()
            }
            null
        } catch (e: IncorrectPlaceCinema) {
            e.message
        } catch (e: IncorrectInputPlaceCinema) {
            e.message
        }

        return placeCorrect
    }

    private fun checkCorrectStyle(style: String?): String? {
        val styleCorrect = try {
            if(style == null || style.all {it.isDigit()}) {
                throw IncorrectStyleMovie()
            }
            null
        } catch (e: IncorrectNameMovie) {
            e.message
        }

        return styleCorrect
    }

    private fun checkCorrectCommand(command: String?): String? {
        val commandCorrect = try {
            if(command?.toIntOrNull() == null || (command.toInt() > globalData.COUNT_COMMAND
                        && command.toInt() < 1)) {
                throw IncorrectCommand()
            }
            null
        } catch (e: IncorrectCommand) {
            e.message
        }

        return commandCorrect
    }
}
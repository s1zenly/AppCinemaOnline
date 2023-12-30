package ru.hse.sema.homework.fronted.model


/**
 * Singleton class which converts correct data
 */
object ConverterData {

    fun getCorrectCinemaHall(list: List<String?>): Pair<Int, Int> {
        val(row, place) = list

        return Pair(row!!.toInt(), place!!.toInt())
    }

    fun getCorrectCommand(command: String?): Int {
        return command!!.toInt()
    }

}
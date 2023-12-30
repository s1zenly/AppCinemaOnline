package ru.hse.sema.homework.fronted.model


object ConverterData {

    fun getCorrectCinemaHall(list: List<String?>): Pair<Int, Int> {
        val(row, place) = list

        return Pair(row!!.toInt(), place!!.toInt())
    }

    fun getCorrectCommand(command: String?): Int {
        return command!!.toInt()
    }

}
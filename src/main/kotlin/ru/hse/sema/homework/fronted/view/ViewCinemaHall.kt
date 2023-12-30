package ru.hse.sema.homework.fronted.view


/**
 * Singleton class which displays cinema hall
 */
object ViewCinemaHall {

    fun view(hall: Array<Array<String>>) {
        for(row in hall){
            println(row.joinToString(" "))
        }
    }
}
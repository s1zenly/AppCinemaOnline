package ru.hse.sema.homework.fronted.view

object ViewCinemaHall {

    fun view(hall: Array<Array<String>>) {
        for(row in hall){
            println(row.joinToString(" "))
        }
    }
}
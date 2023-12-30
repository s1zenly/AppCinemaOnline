package ru.hse.sema.homework.fronted.view

import ru.hse.sema.homework.backend.model.data.Session

/**
 * Singleton class which displays list data
 */
object ViewList {

    fun view(list: List<Any>) {
        for(entity in list) {
            println(entity.toString())
            println("-------------------------------------------------")
        }
    }
}
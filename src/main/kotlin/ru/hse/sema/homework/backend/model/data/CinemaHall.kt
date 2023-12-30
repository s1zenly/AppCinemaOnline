package ru.hse.sema.homework.backend.model.data

import ru.hse.sema.homework.backend.backendGlobalData

data class CinemaHall(
    private val length: Int,
    private val width: Int,
) {

    private val hall: Array<Array<String>> = Array(length) {Array(width) {
        backendGlobalData.getViewColorText.viewGreenText("#")
    }}

    val getHall: Array<Array<String>>
        get() = hall

}

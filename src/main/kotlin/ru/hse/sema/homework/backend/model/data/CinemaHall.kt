package ru.hse.sema.homework.backend.model.data

import ru.hse.sema.homework.backend.backendGlobalData

data class CinemaHall(
    val length: Int,
    val width: Int,
) {

    val hall: Array<Array<String>> = Array(length) {Array(width) {
        backendGlobalData.viewColorText.viewGreenText("#")
    }}

}

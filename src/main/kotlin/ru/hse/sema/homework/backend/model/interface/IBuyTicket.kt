package ru.hse.sema.homework.backend.model.`interface`

interface IBuyTicket {
    var sold: Boolean

    fun hasSoldTicket(): Boolean {
        return sold
    }
}
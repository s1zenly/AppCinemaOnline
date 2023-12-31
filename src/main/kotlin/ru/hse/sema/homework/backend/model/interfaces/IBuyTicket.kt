package ru.hse.sema.homework.backend.model.interfaces

/**
 * Checks if the ticket has been purchased
 */
interface IBuyTicket {
    var sold: Boolean

    fun hasSoldTicket(): Boolean {
        return sold
    }
}
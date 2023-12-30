package ru.hse.sema.homework.backend.model.`interface`

/**
 * Checks if the ticket has been purchased
 */
interface IBuyTicket {
    var sold: Boolean

    fun hasSoldTicket(): Boolean {
        return sold
    }
}
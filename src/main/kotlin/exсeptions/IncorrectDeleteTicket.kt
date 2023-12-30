package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectDeleteTicket(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("The ticket isn't in the database") + "\n"
}
package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectAddTicket(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("The ticket is already in the database") + "\n"
}
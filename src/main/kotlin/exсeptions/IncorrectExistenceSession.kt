package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectExistenceSession(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("The session isn't in the database") + "\n"
}
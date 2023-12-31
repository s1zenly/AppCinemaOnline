package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectAddSession(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("The session is already in the database") + "\n"
}
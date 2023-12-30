package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectCreateSession(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("The session overlaps in time with another one") + "\n"
}
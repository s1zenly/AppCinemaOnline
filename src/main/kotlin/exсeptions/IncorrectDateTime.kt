package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectDateTime(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("That time has already passed") + "\n"
}
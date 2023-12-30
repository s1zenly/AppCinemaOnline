package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectNameMovie(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("Incorrect movie name") + "\n"
}
package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectStyleMovie(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("Incorrect movie style") + "\n"
}
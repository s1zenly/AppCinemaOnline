package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectInputPlaceCinema(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("Incorrect number of place") + "\n"
}
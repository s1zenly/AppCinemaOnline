package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectInputRowCinema(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("Incorrect number of row") + "\n"
}
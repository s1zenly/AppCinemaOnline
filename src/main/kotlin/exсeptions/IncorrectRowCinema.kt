package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectRowCinema(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.getViewColorText.
        viewRedText("There isn't such row in the hall") + "\n"
}
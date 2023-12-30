package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectPlaceCinema(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("There isn't such seat in the hall") + "\n"
}
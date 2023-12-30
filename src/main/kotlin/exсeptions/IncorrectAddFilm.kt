package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectAddFilm(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("The film is already in the database") + "\n"
}
package exсeptions

import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectExistenceFilm(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("The movie isn't in the database") + "\n"
}
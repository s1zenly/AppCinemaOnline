package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectDatabaseIsEmpty(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("Database is empty") + "\n"
}
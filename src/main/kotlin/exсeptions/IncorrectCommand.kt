package exсeptions

import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectCommand(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("You input incorrect command") + "\n"
}
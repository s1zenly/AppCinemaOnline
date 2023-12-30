package exсeptions

import globalData
import ru.hse.sema.homework.backend.backendGlobalData

class IncorrectMarkCustomer(
    cause: Throwable? = null
) : Exception(cause){

    override val message: String
        get() = backendGlobalData.viewColorText.
        viewRedText("The ticket hasn't been purchased") + "\n"
}
package ru.hse.sema.homework.fronted.handler

import actions.ActionsSystem
import ru.hse.sema.homework.fronted.frontedGlobalDate

/**
 * Handles requests that are not related to the work of the application
 */
object SystemRequestHandler {

    fun filesDeleteHandler() = frontedGlobalDate.distributingHandler.systemRequest(ActionsSystem.DELETE_FILES)

}
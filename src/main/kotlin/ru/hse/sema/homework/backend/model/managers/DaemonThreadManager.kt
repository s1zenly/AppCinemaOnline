package ru.hse.sema.homework.backend.model.managers

import ru.hse.sema.homework.backend.backendGlobalData

/**
 * Singleton class which processes all threads
 */
object DaemonThreadManager {

    fun start() {
        backendGlobalData.sessionCleanupThread.start()
    }

}
package ru.hse.sema.homework.backend.model.daemon

import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.Session
import java.time.LocalDateTime
import kotlin.concurrent.timer

/**
 * Daemon thread that deletes terminated sessions from the database
 */
object SessionCleanupThread: Thread() {

    override fun start() {
        timer(name = "sessionCleanupThread", daemon = true, initialDelay = 0, period = 10000) {
            val sessionList = backendGlobalData.databaseSessions.getListSessionRead
            val currentTime = LocalDateTime.now()

            for(session in sessionList) {
                if(currentTime.isAfter(session.date) || currentTime.equals(session.date)) {
                    session.started = true
                }
                if(currentTime.isAfter(session.getTimeEnd())) {
                    backendGlobalData.sessionManager.deleteSession(session)
                }
            }

        }
    }
}
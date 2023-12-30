package ru.hse.sema.homework.backend.model.managers

import exсeptions.IncorrectCreateSession
import exсeptions.IncorrectDateTime
import exсeptions.IncorrectExistenceSession
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.CinemaHall
import ru.hse.sema.homework.backend.model.data.Session
import ru.hse.sema.homework.backend.model.database.DatabaseSessions
import java.time.LocalDateTime

object SessionManager {

    fun createSession(session: Session): Pair<Session?, String?> {
        val result = try {

            if(!checkCorrectSession(session)) throw  IncorrectDateTime()

            if(!checkIntersectionSession(session))
            {
                backendGlobalData.getDatabaseSessions.getListSessionWrite.add(session)
                Pair(session, null)
            } else {
                throw IncorrectCreateSession()
            }
        } catch (e: IncorrectCreateSession) {
            Pair(session, e.message)
        } catch (e: IncorrectDateTime) {
            Pair(session, e.message)
        }

        return result
    }

    fun deleteSession(session: Session): Pair<Session?, String?> {
        val result = try {

            if(!checkCorrectSession(session)) throw IncorrectDateTime()

            if(!checkSession(session)) {
                backendGlobalData.getDatabaseSessions.getListSessionWrite.remove(session)
                Pair(session, null)
            } else {
                throw IncorrectExistenceSession()
            }
        } catch (e: IncorrectExistenceSession) {
            Pair(session, e.message)
        } catch (e: IncorrectDateTime) {
            Pair(session, e.message)
        }

        return result
    }

    fun changeSession(oldSession: Session, newSession: Session): Pair<Session?, String?> {
        val resultOne = deleteSession(oldSession)
        val resultTwo = createSession(newSession)

        if(resultOne.second != null) return Pair(oldSession, resultOne.second)
        if(resultTwo.second != null) return Pair(newSession, resultTwo.second)

        return Pair(newSession, null)
    }




    fun checkSession(session: Session): Boolean = backendGlobalData.getDatabaseSessions.getListSessionRead.contains(session)


    fun checkCorrectSession(session: Session): Boolean = session.getDate.isAfter(LocalDateTime.now())


    private fun checkIntersectionSession(session: Session): Boolean {

        return backendGlobalData.getDatabaseSessions.getListSessionRead.any {
            it.getDate.year == session.getDate.year &&
                it.getDate.month == session.getDate.month &&
                it.getDate.dayOfWeek == session.getDate.dayOfWeek &&
                (((it.getTimeEnd().isAfter(session.getDate)) &&
                        it.getDate.isBefore(session.getDate)) ||
                        (it.getTimeEnd()).isAfter(session.getTimeEnd()) &&
                        it.getDate.isBefore(session.getTimeEnd())) }
    }
}
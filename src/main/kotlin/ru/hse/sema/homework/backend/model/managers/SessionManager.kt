package ru.hse.sema.homework.backend.model.managers

import exсeptions.IncorrectAddSession
import exсeptions.IncorrectCreateSession
import exсeptions.IncorrectDateTime
import exсeptions.IncorrectExistenceSession
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.CinemaHall
import ru.hse.sema.homework.backend.model.data.Session
import ru.hse.sema.homework.backend.model.database.DatabaseSessions
import ru.hse.sema.homework.backend.model.enums.SerializationPath
import java.time.LocalDateTime


/**
 * Singleton class which processes session commands
 */
object SessionManager {

    fun createSession(session: Session): Pair<Session?, String?> {
        val result = try {

            if(!checkCorrectSession(session)) throw  IncorrectDateTime()
            if(checkSession(session)) throw IncorrectAddSession()
            if(checkIntersectionSession(session)) throw IncorrectCreateSession()

            backendGlobalData.databaseSessions.getListSessionWrite.add(session)
            serializationSessionList()
            Pair(session, null)

        } catch (e: IncorrectCreateSession) {
            Pair(session, e.message)
        } catch (e: IncorrectDateTime) {
            Pair(session, e.message)
        } catch (e: IncorrectAddSession) {
            Pair(session, e.message)
        }

        return result
    }

    fun deleteSession(session: Session): Pair<Session?, String?> {
        val result = try {

            if(!checkSession(session)) throw IncorrectExistenceSession()

            backendGlobalData.databaseSessions.getListSessionWrite.remove(session)
            serializationSessionList()
            Pair(session, null)

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




    fun checkSession(session: Session): Boolean = backendGlobalData.databaseSessions.getListSessionRead.contains(session)


    fun checkCorrectSession(session: Session): Boolean = session.date.isAfter(LocalDateTime.now())


    private fun checkIntersectionSession(session: Session): Boolean {

        return backendGlobalData.databaseSessions.getListSessionRead.any {
            it.date.year == session.date.year &&
                it.date.month == session.date.month &&
                it.date.dayOfWeek == session.date.dayOfWeek &&
                (((it.getTimeEnd().isAfter(session.date)) &&
                        it.date.isBefore(session.date)) ||
                        (it.getTimeEnd()).isAfter(session.getTimeEnd()) &&
                        it.date.isBefore(session.getTimeEnd())) }
    }

    private fun serializationSessionList() = backendGlobalData.converterJson.
            convert(backendGlobalData.databaseSessions.getListSessionRead, SerializationPath.LIST_SESSIONS)
}
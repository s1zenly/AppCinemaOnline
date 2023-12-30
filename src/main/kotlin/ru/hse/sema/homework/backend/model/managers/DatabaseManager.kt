package ru.hse.sema.homework.backend.model.managers

import exсeptions.IncorrectDatabaseIsEmpty
import exсeptions.IncorrectExistenceSession
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.Session

object DatabaseManager {

    fun getListSession(): Pair<Any?, String?> {
        val dataList = backendGlobalData.databaseSessions.getListSessionRead
        val answer = try {
            if(dataList.isEmpty()) throw IncorrectDatabaseIsEmpty()

            Pair(dataList, null)
        } catch (e: IncorrectDatabaseIsEmpty) {
            Pair(null, e.message)
        }

        return answer
    }

    fun getListMovies(): Pair<Any?, String?> {
        val dataList = backendGlobalData.databaseFilms.getListFilmsRead
        val answer = try {
            if(dataList.isEmpty()) throw IncorrectDatabaseIsEmpty()

            Pair(dataList, null)
        } catch (e: IncorrectDatabaseIsEmpty) {
            Pair(null, e.message)
        }

        return answer
    }

    fun getListTickets(session: Session): Pair<Any?, String?> {
        val dataList = session.ticketList
        val answer = try {
            if(dataList.isEmpty()) throw IncorrectDatabaseIsEmpty()

            Pair(dataList, null)
        } catch (e: IncorrectDatabaseIsEmpty) {
            Pair(null, e.message)
        }

        return answer
    }

}
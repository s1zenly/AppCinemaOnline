package ru.hse.sema.homework.backend.model.database

import exсeptions.IncorrectCreateSession
import exсeptions.IncorrectDateTime
import exсeptions.IncorrectExistenceSession
import ru.hse.sema.homework.backend.model.data.CinemaHall
import ru.hse.sema.homework.backend.model.data.Session
import java.time.LocalDateTime

object DatabaseSessions {

    private val listSession: MutableList<Session> = mutableListOf()

    // Read-only
    val getListSessionRead: List<Session>
        get() = listSession.toList()

    val getListSessionWrite: MutableList<Session>
        get() = listSession


}

package ru.hse.sema.homework.backend.model.database

import ru.hse.sema.homework.backend.model.data.Session


object DatabaseSessions {

    private val listSession: MutableList<Session> = mutableListOf()

    // Read-only
    val getListSessionRead: List<Session>
        get() = listSession.toList()

    val getListSessionWrite: MutableList<Session>
        get() = listSession


}

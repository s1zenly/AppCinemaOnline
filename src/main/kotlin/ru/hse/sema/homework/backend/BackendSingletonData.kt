package ru.hse.sema.homework.backend

import ru.hse.sema.homework.backend.handler.CinemaHandler
import ru.hse.sema.homework.backend.model.converter.ConvertDataInEntity
import ru.hse.sema.homework.backend.model.database.DatabaseFilms
import ru.hse.sema.homework.backend.model.database.DatabaseSessions
import ru.hse.sema.homework.backend.model.managers.*
import ru.hse.sema.homework.backend.view.ViewColorText

object BackendSingletonData {
    private val dataBaseFilms: DatabaseFilms = DatabaseFilms
    private val dataBaseSessions: DatabaseSessions = DatabaseSessions
    private val cinemaHandler: CinemaHandler = CinemaHandler
    private val converterDataInEntity: ConvertDataInEntity = ConvertDataInEntity
    private val movieManager: MovieManager = MovieManager
    private val sessionManager: SessionManager = SessionManager
    private val ticketManager: TicketManager = TicketManager
    private val cinemaHallManager: CinemaHallManager = CinemaHallManager
    private val viewColorText: ViewColorText = ViewColorText
    private val databaseManager: DatabaseManager = DatabaseManager


    val getDatabaseFilms: DatabaseFilms
        get() = dataBaseFilms

    val getDatabaseSessions: DatabaseSessions
        get() = dataBaseSessions

    val getCinemaHandler: CinemaHandler
        get() = cinemaHandler

    val getConverterDataInEntity: ConvertDataInEntity
        get() = converterDataInEntity

    val getMovieManager: MovieManager
        get() = movieManager

    val getSessionManager: SessionManager
        get() = sessionManager

    val getTicketManager: TicketManager
        get() = ticketManager

    val getCinemaHallManager: CinemaHallManager
        get() = cinemaHallManager

    val getViewColorText: ViewColorText
        get() = viewColorText

    val getDatabaseManager: DatabaseManager
        get() = databaseManager
}
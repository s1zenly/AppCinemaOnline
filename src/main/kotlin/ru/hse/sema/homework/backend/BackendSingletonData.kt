package ru.hse.sema.homework.backend

import ru.hse.sema.homework.backend.handler.CinemaHandler
import ru.hse.sema.homework.backend.handler.SystemHandler
import ru.hse.sema.homework.backend.model.converter.ConverterDataInEntity
import ru.hse.sema.homework.backend.model.converter.ConverterJson
import ru.hse.sema.homework.backend.model.data.LocalDateTimeSerializer
import ru.hse.sema.homework.backend.model.database.DatabaseFilms
import ru.hse.sema.homework.backend.model.database.DatabaseSessions
import ru.hse.sema.homework.backend.model.managers.*
import ru.hse.sema.homework.backend.view.ViewColorText

/**
 * Singleton class with global values for backend part the program
 */
object BackendSingletonData {
    val databaseFilms: DatabaseFilms = DatabaseFilms
    val databaseSessions: DatabaseSessions = DatabaseSessions
    val cinemaHandler: CinemaHandler = CinemaHandler
    val converterDataInEntity: ConverterDataInEntity = ConverterDataInEntity
    val movieManager: MovieManager = MovieManager
    val sessionManager: SessionManager = SessionManager
    val ticketManager: TicketManager = TicketManager
    val cinemaHallManager: CinemaHallManager = CinemaHallManager
    val viewColorText: ViewColorText = ViewColorText
    val databaseManager: DatabaseManager = DatabaseManager
    val converterJson: ConverterJson = ConverterJson
    val localDateTimeSerializer: LocalDateTimeSerializer = LocalDateTimeSerializer
    val systemHandler: SystemHandler = SystemHandler
    val systemManager: SystemManager = SystemManager

}
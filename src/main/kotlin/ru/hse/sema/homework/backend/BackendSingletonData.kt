package ru.hse.sema.homework.backend

import ru.hse.sema.homework.backend.handler.CinemaHandler
import ru.hse.sema.homework.backend.model.converter.ConvertDataInEntity
import ru.hse.sema.homework.backend.model.converter.ConverterJson
import ru.hse.sema.homework.backend.model.data.LocalDateTimeSerializer
import ru.hse.sema.homework.backend.model.database.DatabaseFilms
import ru.hse.sema.homework.backend.model.database.DatabaseSessions
import ru.hse.sema.homework.backend.model.managers.*
import ru.hse.sema.homework.backend.view.ViewColorText

object BackendSingletonData {
    val databaseFilms: DatabaseFilms = DatabaseFilms
    val databaseSessions: DatabaseSessions = DatabaseSessions
    val cinemaHandler: CinemaHandler = CinemaHandler
    val converterDataInEntity: ConvertDataInEntity = ConvertDataInEntity
    val movieManager: MovieManager = MovieManager
    val sessionManager: SessionManager = SessionManager
    val ticketManager: TicketManager = TicketManager
    val cinemaHallManager: CinemaHallManager = CinemaHallManager
    val viewColorText: ViewColorText = ViewColorText
    val databaseManager: DatabaseManager = DatabaseManager
    val converterJson: ConverterJson = ConverterJson
    val localDateTimeSerializer: LocalDateTimeSerializer = LocalDateTimeSerializer

}
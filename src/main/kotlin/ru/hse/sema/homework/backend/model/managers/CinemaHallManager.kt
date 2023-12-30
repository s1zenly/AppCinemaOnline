package ru.hse.sema.homework.backend.model.managers

import exсeptions.IncorrectDateTime
import exсeptions.IncorrectExistenceSession
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.CinemaHall
import ru.hse.sema.homework.backend.model.data.Session
import ru.hse.sema.homework.backend.model.data.Ticket
import ru.hse.sema.homework.backend.model.enums.Colors
import java.awt.Color

object CinemaHallManager {

    fun displayHall(session: Session): Pair<Array<Array<String>>?, String?> {
        val result = try {
            if(!backendGlobalData.sessionManager.checkCorrectSession(session)) throw IncorrectDateTime()

            if(!backendGlobalData.sessionManager.checkSession(session)) throw IncorrectExistenceSession()

            Pair(session.cinemaHall.hall, null)
        } catch (e: IncorrectDateTime) {
            Pair(null, e.message)
        } catch (e: IncorrectExistenceSession) {
            Pair(null, e.message)
        }

        return result
    }

    fun markSeatTaken(ticket: Ticket, session: Session, color: Colors): Array<Array<String>>? {
        val colorSeat = when(color) {
            Colors.RED -> backendGlobalData.viewColorText.viewRedText("#")
            Colors.GREEN -> backendGlobalData.viewColorText.viewGreenText("#")
            Colors.YELLOW -> backendGlobalData.viewColorText.viewYellowText("#")
        }

        session.cinemaHall.hall[ticket.seat.first - 1][ticket.seat.second - 1] = colorSeat

        return session.cinemaHall.hall
    }

}
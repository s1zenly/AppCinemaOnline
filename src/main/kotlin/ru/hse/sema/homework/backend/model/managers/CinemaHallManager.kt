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
            if(!backendGlobalData.getSessionManager.checkCorrectSession(session)) throw IncorrectDateTime()

            if(!backendGlobalData.getSessionManager.checkSession(session)) throw IncorrectExistenceSession()

            Pair(session.getCinemaHall.getHall, null)
        } catch (e: IncorrectDateTime) {
            Pair(null, e.message)
        } catch (e: IncorrectExistenceSession) {
            Pair(null, e.message)
        }

        return result
    }

    fun markSeatTaken(ticket: Ticket, session: Session, color: Colors): Array<Array<String>>? {
        val colorSeat = when(color) {
            Colors.RED -> backendGlobalData.getViewColorText.viewRedText("#")
            Colors.GREEN -> backendGlobalData.getViewColorText.viewGreenText("#")
            Colors.YELLOW -> backendGlobalData.getViewColorText.viewYellowText("#")
        }

        session.getCinemaHall.getHall[ticket.getSeat.first - 1][ticket.getSeat.second - 1] = colorSeat

        return session.getCinemaHall.getHall
    }

}
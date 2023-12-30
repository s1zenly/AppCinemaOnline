package ru.hse.sema.homework.backend.model.managers

import exсeptions.IncorrectAddTicket
import exсeptions.IncorrectDeleteTicket
import exсeptions.IncorrectExistenceSession
import exсeptions.IncorrectMarkCustomer
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.CinemaHall
import ru.hse.sema.homework.backend.model.data.Session
import ru.hse.sema.homework.backend.model.data.Ticket
import ru.hse.sema.homework.backend.model.enums.Colors
import ru.hse.sema.homework.backend.model.enums.SerializationPath
import java.awt.Color
import java.util.Collections

object TicketManager {

    fun addTicket(ticket: Ticket): Pair<Ticket?, String?> {
        val session = getSession(ticket)

        val answer = try {
            if (session == null) throw IncorrectExistenceSession()
            if (checkTicket(session, ticket)) throw IncorrectAddTicket()

            session.ticketList.add(ticket)
            ticket.sold = true
            backendGlobalData.cinemaHallManager.markSeatTaken(ticket, session, Colors.RED)
            serializationTicketList()
            Pair(ticket, null)

        } catch (e: IncorrectExistenceSession) {
            Pair(ticket, e.message)
        } catch (e: IncorrectAddTicket) {
            Pair(ticket, e.message)
        }

        return answer
    }

    fun removeTicket(ticket: Ticket): Pair<Ticket?, String?> {
        val session = getSession(ticket)

        val answer = try {
            if (session == null) throw IncorrectExistenceSession()
            if (!checkTicket(session, ticket)) throw IncorrectDeleteTicket()

            session.ticketList.remove(ticket)
            ticket.sold = false
            backendGlobalData.cinemaHallManager.markSeatTaken(ticket, session, Colors.GREEN)
            serializationTicketList()
            Pair(ticket, null)

        } catch (e: IncorrectExistenceSession) {
            Pair(ticket, e.message)
        }

        return answer
    }

    fun markCustomer(ticket: Ticket): Pair<Any?, String?> {
        val session = getSession(ticket)

        val answer = try {
            if (session == null) throw IncorrectExistenceSession()
            if (!session.ticketList.find { it: Ticket -> ticket.equals(it) }!!.sold) throw IncorrectMarkCustomer()

            Pair(backendGlobalData.cinemaHallManager.markSeatTaken(ticket, session, Colors.YELLOW), null)
        } catch (e: IncorrectExistenceSession) {
            Pair(ticket, e.message)
        } catch (e: IncorrectMarkCustomer) {
            Pair(ticket, e.message)
        }

        return answer
    }


    private fun getSession(ticket: Ticket) = backendGlobalData.databaseSessions.getListSessionRead.filter {
        it.movie.name == ticket.movieName &&
                it.date == ticket.date &&
                it.movie.duration == ticket.duration
    }.firstOrNull()

    private fun checkTicket(session: Session, ticket: Ticket) = session.ticketList.contains(ticket)

    private fun serializationTicketList() = backendGlobalData.converterJson.convert(
        backendGlobalData.databaseSessions.getListSessionRead.flatMap { session ->
            session.ticketList
        }, SerializationPath.LIST_TICKETS
    )
}
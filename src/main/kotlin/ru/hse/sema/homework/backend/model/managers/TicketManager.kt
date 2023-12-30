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
import java.awt.Color

object TicketManager {

    fun addTicket(ticket: Ticket): Pair<Ticket?, String?> {
        val session = getSession(ticket)

        val answer = try {
            if(session == null) throw IncorrectExistenceSession()
            if(checkTicket(session, ticket)) throw IncorrectAddTicket()

            session.getTicketList.add(ticket)
            ticket.sold = true
            backendGlobalData.getCinemaHallManager.markSeatTaken(ticket, session, Colors.RED)
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
            if(session == null) throw IncorrectExistenceSession()
            if(!checkTicket(session, ticket)) throw IncorrectDeleteTicket()

            session.getTicketList.remove(ticket)
            ticket.sold = false
            backendGlobalData.getCinemaHallManager.markSeatTaken(ticket, session, Colors.GREEN)

            Pair(ticket, null)
        } catch (e: IncorrectExistenceSession) {
            Pair(ticket, e.message)
        }

        return answer
    }

    fun markCustomer(ticket: Ticket): Pair<Any?, String?> {
        val session = getSession(ticket)

        val answer = try {
            if(session == null) throw  IncorrectExistenceSession()
            if(!session.getTicketList.find { it: Ticket -> ticket.equals(it)}!!.sold) throw IncorrectMarkCustomer()

            Pair(backendGlobalData.getCinemaHallManager.markSeatTaken(ticket, session, Colors.YELLOW), null)
        } catch (e: IncorrectExistenceSession) {
            Pair(ticket, e.message)
        } catch (e: IncorrectMarkCustomer) {
            Pair(ticket, e.message)
        }

        return answer
    }


    private fun getSession(ticket: Ticket) = backendGlobalData.getDatabaseSessions.getListSessionRead.filter {
        it.getMovie.getName == ticket.getMovieName &&
                it.getDate == ticket.getDate &&
                it.getMovie.getDuration ==ticket.getDuration
    }.firstOrNull()

    private fun checkTicket(session: Session, ticket: Ticket) = session.getTicketList.contains(ticket)
}
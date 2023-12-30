package ru.hse.sema.homework.fronted.view

import ru.hse.sema.homework.backend.model.data.Movie
import ru.hse.sema.homework.backend.model.data.Session
import ru.hse.sema.homework.backend.model.data.Ticket
import actionsCinema.ActionsCinema
import ru.hse.sema.homework.fronted.frontedGlobalDate

object ViewResult {

    fun view(action: ActionsCinema?, entity: Any?) {
        when(action) {
            ActionsCinema.BUY_TICKET -> {
                println("---------------------------------------")
                println("Билет успешно добавлен!")
                println((entity as Ticket).toString())
            }
            ActionsCinema.RETURN_TICKET -> {
                println("---------------------------------------")
                println("Возвращение билета прошло успешно!")
                println((entity as Ticket).toString())
            }
            ActionsCinema.MARK_CUSTOMER -> {
                println("---------------------------------------")
                println("Посетитель отмечены!")
                val hall = entity!! as Array<Array<String>>
                frontedGlobalDate.getViewCinemaHall.view(hall)
            }
            ActionsCinema.DISPLAY_HALL -> {
                println("---------------------------------------")
                val hall = entity!! as Array<Array<String>>
                frontedGlobalDate.getViewCinemaHall.view(hall)
            }
            ActionsCinema.ADD_FILM -> {
                println("---------------------------------------")
                println("Фильм успешно добавлен в прокат!")
                println((entity as Movie).toString())
            }
            ActionsCinema.REMOVE_FILM -> {
                println("---------------------------------------")
                println("Фильм убран из проката!")
                println((entity as Movie).toString())
            }
            ActionsCinema.ADD_SESSION -> {
                println("---------------------------------------")
                println("Сеанс успешно создан!")
                println((entity as Session).toString())
            }
            ActionsCinema.REMOVE_SESSION -> {
                println("---------------------------------------")
                println("Сеанс успешно удален!")
                println((entity as Session).toString())
            }
            ActionsCinema.CHANGE_SESSION -> {
                println("---------------------------------------")
                println("Сеанс успешно изменен!")
                println((entity as Session).toString())
            }
            ActionsCinema.GET_LIST_SESSIONS -> {
                val listSession = entity as List<Session>
                println("Список сеансов:")
                println("---------------------------------------")
                frontedGlobalDate.getViewList.view(listSession)
            }
            ActionsCinema.GET_LIST_MOVIES -> {
                val listMovies = entity as List<Movie>
                println("Список фильмов")
                println("---------------------------------------")
                frontedGlobalDate.getViewList.view(listMovies)
            }
            ActionsCinema.GET_LIST_TICKETS -> {
                val listTickets = entity as List<Ticket>
                println("Список купленных билетов")
                println("---------------------------------------")
                frontedGlobalDate.getViewList.view(listTickets)
            }

            else -> println(entity.toString())
        }
    }

}
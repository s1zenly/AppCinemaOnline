package ru.hse.sema.homework.backend.model.database

import ru.hse.sema.homework.backend.model.data.Movie

object DatabaseFilms {

    private val listFilms: MutableList<Movie> = mutableListOf()

    // Read-only
    val getListFilmsRead: List<Movie>
        get() = listFilms.toList()

    val getListFilmsWrite: MutableList<Movie>
        get() = listFilms

}
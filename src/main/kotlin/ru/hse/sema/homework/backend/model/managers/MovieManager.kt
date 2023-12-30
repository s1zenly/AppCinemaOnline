package ru.hse.sema.homework.backend.model.managers

import exсeptions.IncorrectAddFilm
import exсeptions.IncorrectExistenceFilm
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.Movie

object MovieManager {

    fun addFilms(movie: Movie): Pair<Movie?, String?> {
        val result = try {
            if(!checkFilm(movie)) {
                backendGlobalData.getDatabaseFilms.getListFilmsWrite.add(movie)
                Pair(movie, null)
            } else {
                throw IncorrectAddFilm()
            }
        } catch (e: IncorrectAddFilm) {
            Pair(movie, e.message)
        }

        return result
    }

    fun deleteFilms(movie: Movie): Pair<Movie?, String?> {
        val result = try {
            if(checkFilm(movie)) {
                backendGlobalData.getDatabaseFilms.getListFilmsWrite.remove(movie)
                Pair(movie, null)
            } else {
                throw IncorrectExistenceFilm()
            }
        } catch (e: IncorrectExistenceFilm) {
            Pair(movie, e.message)
        }

        return result
    }

    private fun checkFilm(movie: Movie): Boolean = backendGlobalData.getDatabaseFilms.getListFilmsRead.contains(movie)
}
package ru.hse.sema.homework.backend.model.managers

import exсeptions.IncorrectAddFilm
import exсeptions.IncorrectExistenceFilm
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.data.Movie
import ru.hse.sema.homework.backend.model.enums.SerializationPath

object MovieManager {

    fun addFilms(movie: Movie): Pair<Movie?, String?> {
        val result = try {
            if(checkFilm(movie)) throw IncorrectAddFilm()

            backendGlobalData.databaseFilms.getListFilmsWrite.add(movie)
            serializationMoviesList()
            Pair(movie, null)

        } catch (e: IncorrectAddFilm) {
            Pair(movie, e.message)
        }

        return result
    }

    fun deleteFilms(movie: Movie): Pair<Movie?, String?> {
        val result = try {
            if(!checkFilm(movie)) throw IncorrectExistenceFilm()

            backendGlobalData.databaseFilms.getListFilmsWrite.remove(movie)
            serializationMoviesList()
            Pair(movie, null)

        } catch (e: IncorrectExistenceFilm) {
            Pair(movie, e.message)
        }

        return result
    }

    private fun checkFilm(movie: Movie): Boolean = backendGlobalData.databaseFilms.getListFilmsRead.contains(movie)

    private fun serializationMoviesList() = backendGlobalData.converterJson
        .convert(backendGlobalData.databaseFilms.getListFilmsRead, SerializationPath.LIST_MOVIES)
}
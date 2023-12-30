package ru.hse.sema.homework.backend.model.`interface`

/**
 * Checking for the beginning of the movie
 */
interface ISessionActive {
    var started: Boolean

    fun hasMovieStarted(): Boolean {
        return started
    }
}
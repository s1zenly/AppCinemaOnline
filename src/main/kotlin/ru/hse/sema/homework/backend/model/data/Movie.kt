package ru.hse.sema.homework.backend.model.data

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonProperty


data class Movie(
    val name: String,
    val style: String,
    val duration: Int,
    val info: String?
) {

    override fun toString(): String {
        return "Movie: ${name}\n" +
                "Style: ${style}\n" +
                "Duration: ${duration}\n" +
                "Info: ${info}\n"
    }

    override fun equals(other: Any?): Boolean {
        return this.name == (other as Movie).name
    }

}

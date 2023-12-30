package ru.hse.sema.homework.backend.model.data

data class Movie(
    private val name: String,
    private val style: String,
    private val duration: Double,
    private val info: String?
) {
    val getName: String
        get() = name

    val getDuration: Double
        get() = duration

    override fun toString(): String {
        return "Movie: ${name}\n" +
                "Style: ${style}\n" +
                "Duration: ${duration}\n" +
                "Info: ${info}\n"
    }

    override fun equals(other: Any?): Boolean {
        return this.getName == (other as Movie).getName
    }

}

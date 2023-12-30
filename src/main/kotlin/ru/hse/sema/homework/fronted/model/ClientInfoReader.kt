package ru.hse.sema.homework.fronted.model

object ClientInfoReader {

    private const val messageNameFilm: String = "Название фильма: "
    private const val messageDateFilm: String = "Время начала фильма(dd.MM.yyyy HH:mm): "
    private const val messageDuration: String = "Длительность фильма(h.m, например 2 часа 50 мин = 2.5): "
    private const val messageRow: String = "Ряд: "
    private const val messagePlace: String = "Место: "
    private const val messageRows: String = "Рядов: "
    private const val messagePlaces: String = "Мест: "
    private const val messageStyle: String = "Жанр: "
    private const val messageInfoAboutFilm = "Описание фильма(опционально): "
    private const val messageCommand = "Выберите действие из списка: "

    fun ticketReader(): List<String?> {
        println("Введите данные о билете:")
        print(messageNameFilm)
        val name: String? = readlnOrNull()
        print(messageDateFilm)
        val date: String? = readlnOrNull()
        print(messageDuration)
        val duration: String? = readlnOrNull()
        print(messageRow)
        val row: String? = readlnOrNull()
        print(messagePlace)
        val place: String? = readlnOrNull()

        return listOf(name, date, duration, row, place)
    }

    fun sessionReader(): List<String?> {
        println("Введите информацию о сеансе:")
        print(messageNameFilm)
        val name: String? = readlnOrNull()
        print(messageDateFilm)
        val date: String? = readlnOrNull()

        return listOf(name, date)
    }

    fun movieReader(): List<String?> {
        println("Введите информацию о фильме:")
        print(messageNameFilm)
        val name: String? = readlnOrNull()
        print(messageStyle)
        val style: String? = readlnOrNull()
        print(messageDuration)
        val duration: String? = readlnOrNull()
        print(messageInfoAboutFilm)
        val info: String? = readlnOrNull()

        return listOf(name, style, duration, info)
    }

    fun cinemaHallReader() : List<String?> {
        println("Добро пожаловать в кинотеатр! Выберите действия:")
        println("Для начала работы введите количество рядов и мест в каждом")
        print(messageRows)
        val row: String? = readlnOrNull()
        print(messagePlaces)
        val place: String? = readlnOrNull()

        return listOf(row, place)
    }

    fun commandReader(): String? {
        println(messageCommand)

        return readlnOrNull()
    }


}
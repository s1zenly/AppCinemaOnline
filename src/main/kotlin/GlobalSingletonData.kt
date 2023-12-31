import ru.hse.sema.homework.fronted.handler.CustomerHandler
import ru.hse.sema.homework.fronted.handler.SystemRequestHandler
import ru.hse.sema.homework.fronted.handler.ServerRequestHandler
import java.time.format.DateTimeFormatter

/**
 * Singleton class with global values
 */
object GlobalSingletonData {
    const val COUNT_COMMAND: Int = 12
    const val COLOR_RED_HEAD: String = "\u001B[31m"
    const val COLOR_GREEN_HEAD: String = "\u001B[32m"
    const val COLOR_YELLOW_HEAD: String = "\u001B[33m"
    const val COLOR_TAIL: String = "\u001B[0m"
    const val PATH: String = "JsonData\\"
    const val FILE_NAME_MOVIES: String = "movies.json"
    const val FILE_NAME_SESSIONS: String = "sessions.json"
    const val FILE_NAME_TICKETS: String = "tickets.json"

    val systemRequestHandler: SystemRequestHandler = SystemRequestHandler
    val serverRequestHandler: ServerRequestHandler = ServerRequestHandler
    val customerHandler: CustomerHandler = CustomerHandler
    val formatterDateTime = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")!!

    private var singleton: Boolean = false
    private var length: Int = 0
    private var width: Int = 0

    val getLength: Int
        get() = length
    val getWidth: Int
        get() = width

    fun createCinemaHallData(length: Int, width: Int) {
        if(!singleton) {
            this.length = length
            this.width = width
            ending()
        }
    }

    private fun ending() {
        singleton = true
    }
}




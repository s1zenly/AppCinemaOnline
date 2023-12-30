import ru.hse.sema.homework.fronted.handler.CustomerHandler
import java.time.format.DateTimeFormatter

object GlobalSingletonData {
    private const val COUNT_COMMAND: Int = 12
    private const val COLOR_RED_HEAD: String = "\u001B[31m"
    private const val COLOR_GREEN_HEAD: String = "\u001B[32m"
    private const val COLOR_YELLOW_HEAD: String = "\u001B[33m"
    private const val COLOR_TAIL: String = "\u001B[0m"


    private val customerHandler: CustomerHandler = CustomerHandler
    private var singleton: Boolean = false
    private var length: Int = 0
    private var width: Int = 0
    //private var fileName: String


    fun createCinemaHallData(length: Int, width: Int/*, fileName: String*/) {
        if(!singleton) {
            this.length = length
            this.width = width
            //this.fileName = fileName
            ending()
        }
    }

    private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm")

    val getFormatterDateTime: DateTimeFormatter
        get() = formatter

    val getCustomerHandler: CustomerHandler
        get() = customerHandler

    val getLength: Int
        get() = length

    val getWidth: Int
        get() = width

    val getCountCommand: Int
        get() = COUNT_COMMAND

    val getColorRedHead: String
        get() = COLOR_RED_HEAD

    val getColorGreenHead: String
        get() = COLOR_GREEN_HEAD

    val getColorYellowHead: String
        get() = COLOR_YELLOW_HEAD

    val getColorTail: String
        get() = COLOR_TAIL
//    val getFileName: String
//        get() = fileName


    private fun ending() {
        singleton = true
    }
}




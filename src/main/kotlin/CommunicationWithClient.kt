
/**
 * Start program and reading cinemaHall data
 */
fun start() {
    var sizeHall: Pair<Int, Int>? = null

    while(sizeHall == null) {
        sizeHall = globalData.customerHandler.cinemaHallHandler()
    }

    globalData.createCinemaHallData(sizeHall.first, sizeHall.second)

    communicate()
}

/**
 * Executes a single user command
 */
fun communicate() {
    globalData.customerHandler.menuHandler()
    globalData.customerHandler.commandHandler()

    end()
}


/**
 * Returns one more command to execute or break the program
 */
fun end() {
    println("Вы хотите закончить?(y/n)")
    var answer: String = ""
    while(answer != "y" && answer != "n") {
        answer = readln()
    }

    if(answer == "n") communicate()
}
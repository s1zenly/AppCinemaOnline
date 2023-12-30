
fun start() {
    var sizeHall: Pair<Int, Int>? = null

    while(sizeHall == null) {
        sizeHall = globalData.getCustomerHandler.cinemaHallHandler()
    }

    globalData.createCinemaHallData(sizeHall.first, sizeHall.second)

    communicate()
}

fun communicate() {
    globalData.getCustomerHandler.menuHandler()
    globalData.getCustomerHandler.commandHandler()

    end()
}


fun end() {
    println("Вы хотите закончить?(y/n)")
    var answer: String = ""
    while(answer != "y" && answer != "n") {
        answer = readln()
    }

    if(answer == "n") communicate()
}
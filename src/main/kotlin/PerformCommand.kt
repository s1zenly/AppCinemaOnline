import actionsCinema.ActionsCinema


fun performCommand(command: Int) {
    when(command) {
        1 -> globalData.customerHandler.ticketHandler(ActionsCinema.BUY_TICKET)
        2 -> globalData.customerHandler.ticketHandler(ActionsCinema.RETURN_TICKET)
        3 -> globalData.customerHandler.sessionHandler(ActionsCinema.DISPLAY_HALL)
        4 -> globalData.customerHandler.movieHandler(ActionsCinema.ADD_FILM)
        5 -> globalData.customerHandler.movieHandler(ActionsCinema.REMOVE_FILM)
        6 -> globalData.customerHandler.sessionHandler(ActionsCinema.ADD_SESSION)
        7 -> globalData.customerHandler.sessionHandler(ActionsCinema.REMOVE_SESSION)
        8 -> globalData.customerHandler.sessionHandler(ActionsCinema.CHANGE_SESSION)
        9 -> globalData.customerHandler.ticketHandler(ActionsCinema.MARK_CUSTOMER)
        10 -> globalData.customerHandler.databaseInfoHandler(ActionsCinema.GET_LIST_SESSIONS)
        11 -> globalData.customerHandler.databaseInfoHandler(ActionsCinema.GET_LIST_MOVIES)
        12 -> globalData.customerHandler.sessionHandler(ActionsCinema.GET_LIST_TICKETS)
    }
}
import actionsCinema.ActionsCinema


/**
 * Depending on the command, it calls the desired handler
 */
fun performCommand(command: Int) {
    when(command) {
        1 -> globalData.serverRequestHandler.ticketHandler(ActionsCinema.BUY_TICKET)
        2 -> globalData.serverRequestHandler.ticketHandler(ActionsCinema.RETURN_TICKET)
        3 -> globalData.serverRequestHandler.sessionHandler(ActionsCinema.DISPLAY_HALL)
        4 -> globalData.serverRequestHandler.movieHandler(ActionsCinema.ADD_FILM)
        5 -> globalData.serverRequestHandler.movieHandler(ActionsCinema.REMOVE_FILM)
        6 -> globalData.serverRequestHandler.sessionHandler(ActionsCinema.ADD_SESSION)
        7 -> globalData.serverRequestHandler.sessionHandler(ActionsCinema.REMOVE_SESSION)
        8 -> globalData.serverRequestHandler.sessionHandler(ActionsCinema.CHANGE_SESSION)
        9 -> globalData.serverRequestHandler.ticketHandler(ActionsCinema.MARK_CUSTOMER)
        10 -> globalData.serverRequestHandler.databaseInfoHandler(ActionsCinema.GET_LIST_SESSIONS)
        11 -> globalData.serverRequestHandler.databaseInfoHandler(ActionsCinema.GET_LIST_MOVIES)
        12 -> globalData.serverRequestHandler.sessionHandler(ActionsCinema.GET_LIST_TICKETS)
    }
}
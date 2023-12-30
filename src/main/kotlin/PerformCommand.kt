import actionsCinema.ActionsCinema


fun performCommand(command: Int) {
    when(command) {
        1 -> globalData.getCustomerHandler.ticketHandler(ActionsCinema.BUY_TICKET)
        2 -> globalData.getCustomerHandler.ticketHandler(ActionsCinema.RETURN_TICKET)
        3 -> globalData.getCustomerHandler.sessionHandler(ActionsCinema.DISPLAY_HALL)
        4 -> globalData.getCustomerHandler.movieHandler(ActionsCinema.ADD_FILM)
        5 -> globalData.getCustomerHandler.movieHandler(ActionsCinema.REMOVE_FILM)
        6 -> globalData.getCustomerHandler.sessionHandler(ActionsCinema.ADD_SESSION)
        7 -> globalData.getCustomerHandler.sessionHandler(ActionsCinema.REMOVE_SESSION)
        8 -> globalData.getCustomerHandler.sessionHandler(ActionsCinema.CHANGE_SESSION)
        9 -> globalData.getCustomerHandler.ticketHandler(ActionsCinema.MARK_CUSTOMER)
        10 -> globalData.getCustomerHandler.databaseInfoHandler(ActionsCinema.GET_LIST_SESSIONS)
        11 -> globalData.getCustomerHandler.databaseInfoHandler(ActionsCinema.GET_LIST_MOVIES)
        12 -> globalData.getCustomerHandler.sessionHandler(ActionsCinema.GET_LIST_TICKETS)
    }
}
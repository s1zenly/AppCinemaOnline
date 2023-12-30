package ru.hse.sema.homework.fronted

import ru.hse.sema.homework.backend.handler.DistributingHandler
import ru.hse.sema.homework.fronted.model.CheckerCorrectData
import ru.hse.sema.homework.fronted.model.ClientInfoReader
import ru.hse.sema.homework.fronted.model.ConverterData
import ru.hse.sema.homework.fronted.view.ViewCinemaHall
import ru.hse.sema.homework.fronted.view.ViewList
import ru.hse.sema.homework.fronted.view.ViewMenuCapabilities
import ru.hse.sema.homework.fronted.view.ViewResult

object FrontedSingletonData {
    private val clientInfoReader: ClientInfoReader = ClientInfoReader
    private val checkerCorrectData: CheckerCorrectData = CheckerCorrectData
    private val converterData: ConverterData =ConverterData
    private val viewMenuCapabilities: ViewMenuCapabilities  = ViewMenuCapabilities
    private val viewResult: ViewResult = ViewResult
    private val distributingHandler: DistributingHandler = DistributingHandler
    private val viewCinemaHall: ViewCinemaHall = ViewCinemaHall
    private val viewList: ViewList = ViewList


    val getClientInfoReader: ClientInfoReader
        get() = clientInfoReader

    val getCheckerCorrectData: CheckerCorrectData
        get() = checkerCorrectData

    val getConverterData: ConverterData
        get() = converterData

    val getViewMenuCapabilities: ViewMenuCapabilities
        get() = viewMenuCapabilities

    val getViewResult: ViewResult
        get() = viewResult

    val getDistributingHandler: DistributingHandler
        get() = distributingHandler

    val getViewCinemaHall: ViewCinemaHall
        get() = viewCinemaHall


    val getViewList: ViewList
        get() = viewList
}
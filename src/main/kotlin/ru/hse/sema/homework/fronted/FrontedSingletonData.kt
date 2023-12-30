package ru.hse.sema.homework.fronted

import ru.hse.sema.homework.backend.handler.DistributingHandler
import ru.hse.sema.homework.fronted.model.CheckerCorrectData
import ru.hse.sema.homework.fronted.model.ClientInfoReader
import ru.hse.sema.homework.fronted.model.ConverterData
import ru.hse.sema.homework.fronted.view.ViewCinemaHall
import ru.hse.sema.homework.fronted.view.ViewList
import ru.hse.sema.homework.fronted.view.ViewMenuCapabilities
import ru.hse.sema.homework.fronted.view.ViewResult

/**
 * Singleton class with global values for fronted part the program
 */
object FrontedSingletonData {
    val clientInfoReader: ClientInfoReader = ClientInfoReader
    val checkerCorrectData: CheckerCorrectData = CheckerCorrectData
    val converterData: ConverterData =ConverterData
    val viewMenuCapabilities: ViewMenuCapabilities  = ViewMenuCapabilities
    val viewResult: ViewResult = ViewResult
    val distributingHandler: DistributingHandler = DistributingHandler
    val viewCinemaHall: ViewCinemaHall = ViewCinemaHall
    val viewList: ViewList = ViewList

}
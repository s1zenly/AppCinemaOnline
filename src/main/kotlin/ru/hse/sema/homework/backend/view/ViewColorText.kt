package ru.hse.sema.homework.backend.view

import globalData


object ViewColorText {

    fun viewRedText(text: String): String {
        return globalData.getColorRedHead + text + globalData.getColorTail
    }

    fun viewGreenText(text: String): String {
        return globalData.getColorGreenHead + text + globalData.getColorTail
    }

    fun viewYellowText(text: String): String{
        return globalData.getColorYellowHead + text + globalData.getColorTail
    }
}
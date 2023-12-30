package ru.hse.sema.homework.backend.view

import globalData


object ViewColorText {

    fun viewRedText(text: String): String {
        return globalData.COLOR_RED_HEAD + text + globalData.COLOR_TAIL
    }

    fun viewGreenText(text: String): String {
        return globalData.COLOR_GREEN_HEAD + text + globalData.COLOR_TAIL
    }

    fun viewYellowText(text: String): String{
        return globalData.COLOR_YELLOW_HEAD + text + globalData.COLOR_TAIL
    }
}
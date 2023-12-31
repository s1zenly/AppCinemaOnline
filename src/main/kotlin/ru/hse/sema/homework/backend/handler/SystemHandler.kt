package ru.hse.sema.homework.backend.handler

import ru.hse.sema.homework.backend.backendGlobalData

object SystemHandler {


    fun deleteFilesRequest() = backendGlobalData.systemManager.deleteFiles()


}
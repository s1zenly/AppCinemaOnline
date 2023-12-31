package ru.hse.sema.homework.backend.model.managers

import ru.hse.sema.homework.backend.model.enums.SerializationPath
import java.io.File

/**
 *  Executes requests that are not related to the work of the application
 */
object SystemManager {

    fun deleteFiles() {
        for(path in SerializationPath.entries) {
            val file = File(path.toString())
            if(file.exists()) {
                file.delete()
            }
        }
    }

}
package ru.hse.sema.homework.backend.model.enums

import globalData

enum class SerializationPath {
    LIST_MOVIES {
        override fun toString(): String {
            return globalData.PATH + globalData.FILE_NAME_MOVIES
        }
    },
    LIST_SESSIONS {
        override fun toString(): String {
            return globalData.PATH + globalData.FILE_NAME_SESSIONS
        }
                  },
    LIST_TICKETS {
        override fun toString(): String {
            return globalData.PATH + globalData.FILE_NAME_TICKETS
        }
    }
}
package ru.hse.sema.homework.backend.model.data

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import globalData
import java.io.IOException
import java.time.LocalDateTime

object LocalDateTimeSerializer : JsonSerializer<LocalDateTime>() {

    @Throws(IOException::class)
    override fun serialize(
        value: LocalDateTime?,
        jgen: JsonGenerator?,
        provider: SerializerProvider?) {

        jgen?.writeString(value?.format(globalData.formatterDateTime))
    }
}
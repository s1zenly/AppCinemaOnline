package ru.hse.sema.homework.backend.model.converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import ru.hse.sema.homework.backend.backendGlobalData
import ru.hse.sema.homework.backend.model.enums.SerializationPath
import java.io.File
import java.time.LocalDateTime


object ConverterJson {

    fun convert(list: List<Any>, path: SerializationPath) {
        val mapper = ObjectMapper().registerModule(createModuleDateTime())
        val json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list)
        val file = File(path.toString())

        if(!file.exists()) createFile(file)

        file.writeText(json)
    }

    private fun createFile(file: File) = file.createNewFile()

    private fun createModuleDateTime() = SimpleModule().addSerializer(
        LocalDateTime::class.java, backendGlobalData.localDateTimeSerializer)

}
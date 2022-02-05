package com.yoshikipom.dinnerslot

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import org.modelmapper.Converter
import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class CommonBean(converters: List<Converter<*, *>>) {
    private val converters: List<Converter<*, *>>

    init {
        this.converters = converters
    }

    @Bean
    fun modelMapper(): ModelMapper {
        val modelMapper = ModelMapper()
        for (converter in converters) {
            modelMapper.addConverter(converter)
        }
        return modelMapper
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        return objectMapper
    }
}

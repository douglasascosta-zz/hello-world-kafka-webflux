package com.douglas.helloworldkafka.listener

import com.douglas.helloworldkafka.model.HelloWorld
import com.fasterxml.jackson.databind.ObjectMapper
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class HelloWorldListener(private val objectMapper: ObjectMapper) {

    private val logger = KotlinLogging.logger {}

    fun streamListener(message: String) {
        objectMapper.readValue(message, HelloWorld::class.java).let {
            logger.info { "streamListener: received message: ${it.now}" }
        }
    }

    @KafkaListener(id = "topicListener", topics = ["default-topic"])
    fun topicListener(message: String) {
        objectMapper.readValue(message, HelloWorld::class.java).let {
            logger.info { "topicListener: received message: ${it.now}" }
        }
    }
}
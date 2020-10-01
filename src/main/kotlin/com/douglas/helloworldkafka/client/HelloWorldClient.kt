package com.douglas.helloworldkafka.client

import com.douglas.helloworldkafka.model.HelloWorld
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class HelloWorldClient(private val kafkaTemplate: KafkaTemplate<String, String>,
                       private val objectMapper: ObjectMapper) {

    fun helloWorld(helloWorld: Mono<HelloWorld>): Mono<HelloWorld> =
            helloWorld.doOnNext {
                kafkaTemplate.sendDefault(objectMapper.writeValueAsString(it))
            }
}
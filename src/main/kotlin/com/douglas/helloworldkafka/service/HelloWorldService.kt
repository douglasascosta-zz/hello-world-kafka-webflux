package com.douglas.helloworldkafka.service

import com.douglas.helloworldkafka.client.HelloWorldClient
import com.douglas.helloworldkafka.model.HelloWorld
import mu.KotlinLogging
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class HelloWorldService(private val helloWorldClient: HelloWorldClient) {

    private val logger = KotlinLogging.logger {}

    fun helloWorld(): Mono<HelloWorld> = helloWorldClient
            .helloWorld(Mono.just(HelloWorld(now = LocalDateTime.now().toString())))
            .doOnSuccess { logger.error { "helloWorld: message sent, $it" } }
            .doOnError { logger.error { "helloWorld: error sending message: $it" } }
}
package com.douglas.helloworldkafka.config

import com.douglas.helloworldkafka.listener.HelloWorldListener
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.reactive.collect
import mu.KotlinLogging
import org.apache.kafka.clients.admin.NewTopic
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.apache.kafka.streams.kstream.KStream
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.kotlin.core.publisher.toMono

@Configuration
class KafkaConfig(@Value("\${spring.kafka.template.default-topic}")
                  private val defaultTopic: String) {

    private val logger = KotlinLogging.logger {}

    @Bean
    fun topic() = NewTopic(defaultTopic, 1, 1)

    @Bean
    fun kStream(streamsBuilder: StreamsBuilder, helloWorldListener: HelloWorldListener): KStream<String, String> =
            streamsBuilder
                    .stream<String, String>(defaultTopic, Consumed.with(Serdes.String(), Serdes.String()))
                    .peek { _, value -> helloWorldListener.streamListener(value) }
}
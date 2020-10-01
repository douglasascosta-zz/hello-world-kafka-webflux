package com.douglas.helloworldkafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
class HelloWorldKafkaApplication

fun main(args: Array<String>) {
	runApplication<HelloWorldKafkaApplication>(*args)
}
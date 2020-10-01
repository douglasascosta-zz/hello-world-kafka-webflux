package com.douglas.helloworldkafka.controller

import com.douglas.helloworldkafka.service.HelloWorldService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello-world")
class HelloWorldController(private val helloWorldService: HelloWorldService) {

    @GetMapping
    fun helloWorld() = helloWorldService.helloWorld()

}
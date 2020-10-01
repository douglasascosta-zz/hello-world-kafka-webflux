package com.douglas.helloworldkafka.model

import java.util.*

data class HelloWorld(val id: UUID = UUID.randomUUID(), val now: String)
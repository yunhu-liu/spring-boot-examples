package com.luitech.springbootexamples

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringBootExamplesApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootExamplesApplication::class.java, *args)
}
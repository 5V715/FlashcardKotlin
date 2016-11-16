package org.evil

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class FlashcardApplication


fun main(args: Array<String>) {
    SpringApplication.run(FlashcardApplication::class.java, *args)
}
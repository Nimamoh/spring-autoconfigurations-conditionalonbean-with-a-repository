package net.nimamoh.so.conditionalrepositories.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class ConditionalrepositoriesApplication {
    @PostConstruct
    fun afterInit() {
        println("I'm done!")
    }
}

fun main(args: Array<String>) {

    runApplication<ConditionalrepositoriesApplication>(*args)
}

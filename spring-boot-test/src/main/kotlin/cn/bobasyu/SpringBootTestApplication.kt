package cn.bobasyu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootTestApplication

fun main(args: Array<String>) {
    runApplication<SpringBootTestApplication>(*args)
}

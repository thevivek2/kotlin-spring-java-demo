package com.example.demo.example

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.RequestContextHolder
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v2/example")
class HelloWorld(val client: ExampleRestClient) {

    private val logger: Log = LogFactory.getLog(HelloWorld::class.java)


    @GetMapping("/external-api")
    suspend fun get(): ResponseEntity<String> = coroutineScope {
        logger.info("Lets collect few information from main thread")
        val reqAttribute = RequestContextHolder.getRequestAttributes()
        withContext(Dispatchers.IO) {
            logger.info(" reqAttribute  " + reqAttribute)
            logger.info(
                "Thanks... https://www.youtube.com/watch?v=hQrFfwT1IMo&t=1514s \n" +
                        "https://docs.spring.io/spring-framework/reference/languages/kotlin/coroutines.html")
            client.externalUrlGet();
        }
    }

    @GetMapping("/delayed")
    suspend fun delayed(): String = coroutineScope {
        withContext(Dispatchers.Default) {
            delay(5000)
            "Delayed reply after 5000ms " + LocalDateTime.now()
        }
    }

    @GetMapping("/memory")
    suspend fun memory(): String = coroutineScope {
        withContext(Dispatchers.Default) {
            val cores = Runtime.getRuntime().availableProcessors()
            val runtime = Runtime.getRuntime()
            val totalMemory = runtime.totalMemory() / (1024 * 1024) // Total memory available to JVM
            val freeMemory = runtime.freeMemory() / (1024 * 1024) // Free memory within JVM
            val usedMemory = totalMemory - freeMemory // Memory currently in use
            """ Total Memory: ${totalMemory} MB
                 Free Memory: ${freeMemory} MB
                 Used Memory: ${usedMemory} MB
            """.trimIndent() + " CPU cores ${cores}"
        }
    }

    
}

package com.example.demo.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v2/example")
class HelloWorld {

    @GetMapping("/delayed")
    suspend fun helloWorld(): String {
        System.out.println("hello world");
        delay(50000)
        return "Hello World " + LocalDateTime.now()
    }
    @GetMapping("/memory")
    suspend fun helloWorldFromMemory(): String {
        return "this is from memory " + LocalDateTime.now()
    }
    @GetMapping("/do-blocking-external-call")
    suspend fun get(): String = coroutineScope {
        " https://www.youtube.com/watch?v=hQrFfwT1IMo&t=1514s " +
                "https://docs.spring.io/spring-framework/reference/languages/kotlin/coroutines.html " +
                "project.basePath/trace-configuration.txt " +
                "This simply means do whatever here like calling http://httpstat.us/200?sleep=50000 but make sure " +
                "you use RANDOM sleep otherwise fixed delay is quite same :):):)"
    }
}
package com.example.demo

import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RequestMapping("/api/v2/example")
@RestController
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
}
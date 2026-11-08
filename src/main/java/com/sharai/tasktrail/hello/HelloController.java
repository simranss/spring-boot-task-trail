package com.sharai.tasktrail.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController 
public class HelloController {
    public record GreeetingResponse(String message, String time, String methodName) {}

    @GetMapping("/hello")
    public GreeetingResponse hello(@RequestParam(defaultValue = "World") String name) {
        return new GreeetingResponse("Hello, " +  name, Instant.now().toString(), "hello");
    }

    @GetMapping("/hello/{name}")
    public GreeetingResponse helloName(@PathVariable() String name) {
        return new GreeetingResponse("Hello, " +  name, Instant.now().toString(), "helloName");
    }
}

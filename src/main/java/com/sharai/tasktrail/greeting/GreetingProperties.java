package com.sharai.tasktrail.greeting;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.greeting")
public record GreetingProperties(String prefix, boolean shout) {}

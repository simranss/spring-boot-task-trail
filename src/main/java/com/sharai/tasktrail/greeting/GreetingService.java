package com.sharai.tasktrail.greeting;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingProperties props;

    public GreetingService(GreetingProperties props) {
        this.props = props;
    }

    public String greet(String name) {
        String s = props.prefix() + ", " + name;
        return props.shout() ? s.toUpperCase() : s;
    }
}

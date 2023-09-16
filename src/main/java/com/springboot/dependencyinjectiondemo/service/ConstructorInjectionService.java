package com.springboot.dependencyinjectiondemo.service;

import com.springboot.dependencyinjectiondemo.common.domain.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectionService {

    // Q. Why warning to mark this field as final?
    private final GreetingService greetingService;

    @Autowired
    public ConstructorInjectionService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.greet();
    }
}

package com.springboot.dependencyinjectiondemo.service;

import com.springboot.dependencyinjectiondemo.common.domain.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldInjectionService {

    @Autowired
    private GreetingService greetingService;


    // Q. diff of using this.greetingService vs greetingService
    public String getGreeting() {
        return this.greetingService.greet();
    }
}

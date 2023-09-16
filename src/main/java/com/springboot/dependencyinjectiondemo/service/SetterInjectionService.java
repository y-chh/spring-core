package com.springboot.dependencyinjectiondemo.service;

import com.springboot.dependencyinjectiondemo.common.domain.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterInjectionService {

    private GreetingService greetingService;

    @Autowired
    public void setSetterInjectionService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.greet();
    }
}

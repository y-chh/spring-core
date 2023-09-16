package com.springboot.dependencyinjectiondemo.common.service;

import com.springboot.dependencyinjectiondemo.common.domain.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet() {
        return "Welcome to Spring boot";
    }
}

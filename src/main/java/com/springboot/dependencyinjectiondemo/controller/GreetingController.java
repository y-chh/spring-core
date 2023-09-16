package com.springboot.dependencyinjectiondemo.controller;

import com.springboot.dependencyinjectiondemo.service.ConstructorInjectionService;
import com.springboot.dependencyinjectiondemo.service.FieldInjectionService;
import com.springboot.dependencyinjectiondemo.service.SetterInjectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    private final ConstructorInjectionService constructorInjectionService;
    private final SetterInjectionService setterInjectionService;
    private final FieldInjectionService fieldInjectionService;

    public GreetingController(ConstructorInjectionService constructorInjectionService,
                              SetterInjectionService setterInjectionService,
                              FieldInjectionService fieldInjectionService) {
        this.constructorInjectionService = constructorInjectionService;
        this.setterInjectionService = setterInjectionService;
        this.fieldInjectionService = fieldInjectionService;
    }

    @GetMapping("/greet")
    public String greet(Model model) {
        model.addAttribute("constructorInjection", constructorInjectionService.getGreeting());
        model.addAttribute("setterInjection", setterInjectionService.getGreeting());
        model.addAttribute("fieldInjection", fieldInjectionService.getGreeting());
        return "Greetings";
    }



}

package bean_scope.singleton.controller;

import bean_scope.singleton.domain.User;
import bean_scope.singleton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String userName,
                               @RequestParam String email) {
        userService.registerUser(userName,email);
        return "User registered: " + userService.getRegisteredUser();
    }

    @GetMapping("/getRegisteredUser")
    public String getRegisteredUser() {
        User registeredUser = userService.getRegisteredUser();
        if(registeredUser != null) {
            return "Registered User: " + registeredUser;
        }else {
            return "No user registered yet";
        }
    }
}

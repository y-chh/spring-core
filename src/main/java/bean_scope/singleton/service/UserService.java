package bean_scope.singleton.service;

import bean_scope.singleton.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private User registeredUser;

    public void registerUser(String userName, String email) {
        registeredUser = new User(userName,email);
    }

    public User getRegisteredUser() {
        return registeredUser;
    }
}

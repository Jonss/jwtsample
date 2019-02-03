package jupiterstein.com.jwtsample.service;

import jupiterstein.com.jwtsample.models.User;
import jupiterstein.com.jwtsample.repository.UserRepository;
import jupiterstein.com.jwtsample.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser() {
        UserSpringSecurity user = (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(user.getUsername());
    }
}

package com.example.mapper;

import com.example.body.UserRegistration;
import com.example.body.UserResponseBody;
import com.example.object.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserRegistration userRegistration) {
        String nickname = userRegistration.getNickname();
        String password = userRegistration.getPassword();
        String email = userRegistration.getEmail();

        return new User(nickname, password, email);
    }

    public UserResponseBody map(User user) {
        return new UserResponseBody(user.getNickname(), user.getEmail());
    }
}

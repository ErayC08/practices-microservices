package com.example.service;

import com.example.body.UserRegistration;
import com.example.body.UserResponseBody;
import com.example.exception.MailAlreadyExistsException;
import com.example.exception.NicknameAlreadyExistsException;
import com.example.mapper.UserMapper;
import com.example.object.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<UserResponseBody> findAll() {
        return userRepository.getUserList().stream().map(userMapper::map).toList();
    }

    public void save(UserRegistration userRegistration) {
        if (nicknameExists(userRegistration.getNickname())) {
            throw new NicknameAlreadyExistsException();
        }
        if (emailExists(userRegistration.getEmail())) {
            throw new MailAlreadyExistsException();
        }
        userRepository.getUserList().add(userMapper.map(userRegistration));
    }

    private boolean nicknameExists(String nickname) {
        for (User next : userRepository.getUserList()) {
            if (next.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    private boolean emailExists(String email) {
        for (User next : userRepository.getUserList()) {
            if (next.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}

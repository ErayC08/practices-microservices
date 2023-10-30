package com.example.repository;

import com.example.object.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> userList;

    public UserRepository() {
        userList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }
}

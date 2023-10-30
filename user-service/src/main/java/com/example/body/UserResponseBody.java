package com.example.body;

public class UserResponseBody {

    private final String nickname;
    private final String email;

    public UserResponseBody(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}

package com.example.body;

import com.example.exception.MismatchingPasswordException;
import com.example.validator.EmailValidator;
import com.example.validator.NicknameValidator;
import com.example.validator.PasswordValidator;

public class UserRegistration {
    private String nickname;
    private String password;
    private String email;

    public UserRegistration(String nickname, String password, String matchingPassword, String email) {
        if (NicknameValidator.getInstance().validate(nickname)) {
            this.nickname = nickname;
        }
        if (PasswordValidator.getInstance().validate(password) && passwordMatches(password, matchingPassword)) {
            this.password = password;
        }
        if (EmailValidator.getInstance().validate(email)) {
            this.email = email;
        }
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private boolean passwordMatches(String password, String matchingPassword) {
        if (password.equals(matchingPassword)) {
            return true;
        }
        throw new MismatchingPasswordException();
    }
}

package com.example.validator;

import com.example.exception.InvalidNicknameException;
import com.example.exception.NullNicknameException;

public class NicknameValidator implements Validator {
    public static NicknameValidator getInstance() {
        return new NicknameValidator();
    }

    @Override
    public boolean validate(Object o) {
        if (o == null) {
            throw new NullNicknameException();
        }
        String nickname = (String) o;

        for (int i = 0; i < nickname.length(); i++) {
            char c = nickname.charAt(i);

            if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                throw new InvalidNicknameException();
            }
        }
        return true;
    }
}

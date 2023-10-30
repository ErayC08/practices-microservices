package com.example.validator;

import com.example.exception.InvalidPasswordException;
import com.example.exception.NullPasswordException;

public class PasswordValidator implements Validator {
    public static PasswordValidator getInstance() {
        return new PasswordValidator();
    }

    @Override
    public boolean validate(Object o) {
        if (o == null) {
            throw new NullPasswordException();
        }
        String password = (String) o;

        StringBuilder exceptionMessage = new StringBuilder();
        if (!hasValidLength(password)) {
            exceptionMessage.append("The length must be between 8 and 32 (both inclusive). ");
        }
        if (!containsDigit(password)) {
            exceptionMessage.append("It must contain at least one digit. ");
        }
        if (!containsBothCases(password)) {
            exceptionMessage.append("It must contain both uppercase and lowercase letters. ");
        }
        if (exceptionMessage.isEmpty()) {
            return true;
        }
        throw new InvalidPasswordException(exceptionMessage.toString());
    }

    private boolean containsDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsBothCases(String password) {
        return containsLowerCase(password) && containsUpperCase(password);
    }

    private boolean containsLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasValidLength(String password) {
        int length = password.length();

        return 8 <= length && length <= 32;
    }
}

package com.example.validator;

import com.example.exception.InvalidMailException;
import com.example.exception.NullMailException;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {
    private final static String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    public static EmailValidator getInstance() {
        return new EmailValidator();
    }

    @Override
    public boolean validate(Object o) {
        if (o == null) {
            throw new NullMailException();
        }
        String email = (String) o;

        if (!Pattern.compile(EMAIL_REGEX).matcher(email).matches()) {
            throw new InvalidMailException();
        }
        return true;
    }
}

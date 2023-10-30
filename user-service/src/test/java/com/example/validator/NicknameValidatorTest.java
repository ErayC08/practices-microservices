package com.example.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NicknameValidatorTest {

    @Test
    public void givenNicknameWithNonEnglishLetter_whenValidate_thenReturnFalse() {
        String nickname = "Çelik01";

        assertFalse(NicknameValidator.getInstance().validate(nickname));
    }
}

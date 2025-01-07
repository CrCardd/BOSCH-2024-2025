package com.desktopapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTests {

    @Test
    void validateSmallPass() {
        assertEquals(MyPasswordValidator.Validate("oi12321"), false);
        assertEquals(MyPasswordValidator.Validate("1234!aaaaaa"), true);
        assertEquals(MyPasswordValidator.Validate("oio@q1iaaa"), true);
        assertEquals(MyPasswordValidator.Validate("minh"), false);
    }

    @Test
    void validateBigPasswords() {
        assertEquals(MyPasswordValidator.Validate("minhasenha2@123"), true);
        assertEquals(MyPasswordValidator.Validate("12345678asd!90123"), true);
        assertEquals(MyPasswordValidator.Validate("minhasenhagigantesca"), false);
        assertEquals(MyPasswordValidator.Validate("senhaemoji"), false);
    }

    @Test
    void validateMediumPasswordsWithNums() {
        assertEquals(MyPasswordValidator.Validate("senha@123"), true);
        assertEquals(MyPasswordValidator.Validate("12345@"), false);
        assertEquals(MyPasswordValidator.Validate("12345678@9012"), false);
        assertEquals(MyPasswordValidator.Validate("oi88oi@88oi88"), true);
    }

    @Test
    void validateMediumPassowrdsWithoutNums() {
        assertEquals(MyPasswordValidator.Validate("minhasenha"), false);
        assertEquals(MyPasswordValidator.Validate("mysenhaquase"), false);
    }
}
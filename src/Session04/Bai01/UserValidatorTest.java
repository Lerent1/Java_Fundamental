package Session04.Bai01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserValidatorTest {
    @Test
    void TC01_validUsername() {
        String username = "user123";
        boolean result = UserValidator.isValidUsername(username);
        assertTrue(result);
    }

    @Test
    void TC02_usernameTooShort() {
        String username = "abc";
        boolean result = UserValidator.isValidUsername(username);
        assertFalse(result);
    }

    @Test
    void TC03_usernameContainsSpace() {
        String username = "user name";
        boolean result = UserValidator.isValidUsername(username);
        assertFalse(result);
    }

}
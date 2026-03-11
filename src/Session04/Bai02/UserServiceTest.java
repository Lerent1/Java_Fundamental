package Session04.Bai02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    @Test
    void TC01() {
        int age = 18;
        boolean result = UserService.checkRegistrationAge(age);
        assertEquals(true, result);
    }

    @Test
    void TC02() {
        int age = 17;
        boolean result = UserService.checkRegistrationAge(age);
        assertEquals(false, result);
    }

    @Test
    void TC03() {
        int age = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            UserService.checkRegistrationAge(age);
        });
    }
}
package Session04.Bai04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Gioi02Test {

    @Test
    void testPasswordStrengthLevels() {

        assertAll(
                () -> assertEquals("Mạnh",
                        Gioi02.evaluatePasswordStrength("Abc123!@")),
                () -> assertEquals("Trung bình",
                        Gioi02.evaluatePasswordStrength("abc123")),
                () -> assertEquals("Yếu",
                        Gioi02.evaluatePasswordStrength("abc")),
                () -> assertEquals("Yếu",
                        Gioi02.evaluatePasswordStrength("12345"))
        );
    }
}
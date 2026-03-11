package Session04.Bai03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class UserProcessorTest {
    private UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void test01() {
        String email = "user@gmail.com";
        String result = processor.processEmail(email);
        assertEquals("user@gmail.com", result);
    }

    @Test
    void test02() {
        String email = "usergmail.com";
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void test03() {
        String email = "user@";
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void test04() {
        String email = "Example@Gmail.com";
        String result = processor.processEmail(email);
        assertEquals("example@gmail.com", result);
    }
}
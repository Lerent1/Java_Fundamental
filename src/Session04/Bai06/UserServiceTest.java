package Session04.Bai06;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void updateProfile01() {
        User user = new User("old@gmail.com", LocalDate.of(2000,1,1));
        UserProfile profile = new UserProfile("new@gmail.com", LocalDate.of(1999,1,1));

        List<User> users = new ArrayList<>();
        User result = UserService.updateProfile(user, profile, users);

        assertNotNull(result);
    }

    @Test
    void updateProfile02() {
        User user = new User("old@gmail.com", LocalDate.of(2000,1,1));
        UserProfile profile = new UserProfile("new@gmail.com", LocalDate.now().plusDays(1));

        List<User> users = new ArrayList<>();
        User result = UserService.updateProfile(user, profile, users);

        assertNull(result);
    }

    @Test
    void updateProfile03() {
        User user = new User("old@gmail.com", LocalDate.of(2000,1,1));
        User other = new User("dup@gmail.com", LocalDate.of(1995,1,1));

        List<User> users = new ArrayList<>();
        users.add(other);

        UserProfile profile = new UserProfile("dup@gmail.com", LocalDate.of(1999,1,1));
        User result = UserService.updateProfile(user, profile, users);

        assertNull(result);
    }

    @Test
    void updateProfile04() {
        User user = new User("same@gmail.com", LocalDate.of(2000,1,1));
        UserProfile profile = new UserProfile("same@gmail.com", LocalDate.of(1998,1,1));

        List<User> users = new ArrayList<>();
        User result = UserService.updateProfile(user, profile, users);

        assertNotNull(result);
    }

    @Test
    void updateProfile05() {
        User user = new User("old@gmail.com", LocalDate.of(2000,1,1));
        UserProfile profile = new UserProfile("new@gmail.com", LocalDate.of(1999,1,1));

        List<User> users = new ArrayList<>();
        User result = UserService.updateProfile(user, profile, users);

        assertNotNull(result);
    }

    @Test
    void updateProfile06() {
        User user = new User("old@gmail.com", LocalDate.of(2000,1,1));
        User other = new User("dup@gmail.com", LocalDate.of(1995,1,1));

        List<User> users = new ArrayList<>();
        users.add(other);

        UserProfile profile = new UserProfile("dup@gmail.com", LocalDate.now().plusDays(1));
        User result = UserService.updateProfile(user, profile, users);

        assertNull(result);
    }
}
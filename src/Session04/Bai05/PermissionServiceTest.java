package Session04.Bai05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class PermissionServiceTest {
    User admin;
    User moderator;
    User user;

    @Test
    void testAdminPermissions() {
        admin = new User("Admin1", Role.ADMIN);

        assertAll(
                () -> assertTrue(PermissionService.canPerformAction(admin, Action.DELETE_USER)),
                () -> assertTrue(PermissionService.canPerformAction(admin, Action.LOCK_USER)),
                () -> assertTrue(PermissionService.canPerformAction(admin, Action.VIEW_PROFILE))
        );
    }

    @Test
    void testModeratorPermissions() {
        moderator = new User("Mod1", Role.MODERATOR);

        assertAll(
                () -> assertFalse(PermissionService.canPerformAction(moderator, Action.DELETE_USER)),
                () -> assertTrue(PermissionService.canPerformAction(moderator, Action.LOCK_USER)),
                () -> assertTrue(PermissionService.canPerformAction(moderator, Action.VIEW_PROFILE))
        );
    }

    @Test
    void testUserPermissions() {
        user = new User("User1", Role.USER);

        assertAll(
                () -> assertFalse(PermissionService.canPerformAction(user, Action.DELETE_USER)),
                () -> assertFalse(PermissionService.canPerformAction(user, Action.LOCK_USER)),
                () -> assertTrue(PermissionService.canPerformAction(user, Action.VIEW_PROFILE))
        );
    }

    @AfterEach
    void cleanUp() {
        admin = null;
        moderator = null;
        user = null;
    }
}
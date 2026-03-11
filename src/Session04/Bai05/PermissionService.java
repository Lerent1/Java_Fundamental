package Session04.Bai05;

public class PermissionService {
    public static boolean canPerformAction(User user, Action action) {

        switch (user.getRole()) {

            case ADMIN:
                return true;

            case MODERATOR:
                return action == Action.LOCK_USER
                        || action == Action.VIEW_PROFILE;

            case USER:
                return action == Action.VIEW_PROFILE;

            default:
                return false;
        }
    }
}

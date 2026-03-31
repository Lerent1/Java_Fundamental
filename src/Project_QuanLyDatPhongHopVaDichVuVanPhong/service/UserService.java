package Project_QuanLyDatPhongHopVaDichVuVanPhong.service;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.User;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.UserDAO;

public class UserService {
    private static UserDAO userDAO = new UserDAO();

    public static User getUserById(int id) {
        return userDAO.findById(id);
    }

    public static boolean updateUser(User user) {
        return userDAO.update(user);
    }

    public static boolean isUsernameExists(String username) {
        return userDAO.findAll().stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(username));
    }
}
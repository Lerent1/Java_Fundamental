package Project_QuanLyDatPhongHopVaDichVuVanPhong.service;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.UserDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.User;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.PasswordHash;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    public boolean register(String username, String password,  String fullname, String email, String phone) {
        String hash = PasswordHash.hashPassword(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(hash);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole("EMPLOYEE");

        return userDAO.insert(user);
    }

    public User login(String username, String password) {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            System.out.println("Không tìm thấy user!");
            return null;
        }

        boolean isMatch = PasswordHash.checkPassword(password, user.getPassword());

        if (!isMatch) {
            System.out.println("Sai mật khẩu!");
            return null;
        }

        return user;
    }

    public boolean isEmailExist(String email) {
        return userDAO.isEmailExist(email);
    }

    public boolean isPhoneExist(String phone) {
        return userDAO.isPhoneExist(phone);
    }
}
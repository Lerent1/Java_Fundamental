package Project_QuanLyDatPhongHopVaDichVuVanPhong.presentation;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.UserDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.User;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.PasswordHash;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        String hashed = PasswordHash.hashPassword("123456");

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(hashed);
        admin.setRole("ADMIN");
        userDAO.insert(admin);

        AuthUI.start();
    }
}
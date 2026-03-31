package Project_QuanLyDatPhongHopVaDichVuVanPhong.dao;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.User;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
//    public boolean insert(User user) {
//        String sql = "INSERT INTO users(username, password, role) VALUES (?, ?, ?)";
//
//        try (Connection conn = JDBCConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, user.getUsername());
//            ps.setString(2, user.getPassword());
//
//            ps.setString(3, user.getRole());
//
//            return ps.executeUpdate() > 0;
//
//        } catch (Exception e) {
//            if (e.getMessage().contains("Duplicate")) {
//                System.out.println("Username already exists!");
//            } else {
//                System.out.println("Insert user error: " + e.getMessage());
//            }
//            return false;
//        }
//    }

    public boolean insert(User user) {
        String sql = "INSERT INTO users(username, password, role, fullname, email, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getFullname());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhone());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            if (e.getMessage().contains("Duplicate")) {
                System.out.println("Username already exists!");
            } else {
                System.out.println("Insert user error: " + e.getMessage());
            }
            return false;
        }
    }

//    public User findByUsername(String username) {
//        String sql = "SELECT * FROM users WHERE username = ?";
//
//        try (Connection conn = JDBCConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, username);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                User u = new User();
//                u.setId(rs.getInt("id"));
//                u.setUsername(rs.getString("username"));
//                u.setPassword(rs.getString("password"));
//                u.setRole(rs.getString("role"));
//                return u;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createSupport(String username, String password) {
        String sql = "INSERT INTO users(username, password, role) VALUES (?, ?, 'SUPPORT')";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Create support error: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmailExist(String email) {
        String sql = "SELECT id FROM users WHERE email=?";
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            return ps.executeQuery().next();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPhoneExist(String phone) {
        String sql = "SELECT id FROM users WHERE phone=?";
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);
            return ps.executeQuery().next();

        } catch (Exception e) {
            return false;
        }
    }

    public java.util.List<User> findSupportUsers() {
        String sql = "SELECT * FROM users WHERE role = 'SUPPORT'";
        java.util.List<User> list = new java.util.ArrayList<>();

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));

                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ---------------------------------------------

    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public java.util.List<User> findAll() {
        String sql = "SELECT * FROM users";
        java.util.List<User> list = new java.util.ArrayList<>();

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                list.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean update(User user) {
        String sql = "UPDATE users SET username=?, fullname=?, email=?, phone=? WHERE id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setInt(5, user.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
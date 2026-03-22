package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class testMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "chiyeuminhem123";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Kết nối thành công!");

            String create = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(100) NOT NULL)";
            stmt.executeUpdate(create);

            String insert = "INSERT INTO users(name) VALUES ('Java User')";
            stmt.executeUpdate(insert);

            System.out.println("Tạo bảng + Insert OK!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
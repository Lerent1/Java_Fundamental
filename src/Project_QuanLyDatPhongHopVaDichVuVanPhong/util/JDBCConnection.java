package Project_QuanLyDatPhongHopVaDichVuVanPhong.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/project_meeting_java";
    private static final String USER = "root";
    private static final String PASS = "chiyeuminhem123";

    private static Connection connection;

    private JDBCConnection() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASS);
//                System.out.println("Ket noi thanh cong");
            }
        } catch (Exception e) {
            System.out.println("Ket noi that bai: " + e.getMessage());
        }

        return connection;
    }
}
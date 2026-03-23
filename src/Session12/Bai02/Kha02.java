package Session12.Bai02;

// Truyền dữ liệu nhị phân (Binary): Các phương thức setDouble() hay setInt()
// truyền giá trị nguyên bản của biến từ bộ nhớ Java sang Database thông qua
// JDBC Driver. Nó không chuyển số thành chuỗi trung gian.

//Trách nhiệm của Driver: JDBC Driver biết cách giao tiếp với Database bằng giao
// thức chuẩn. Nó sẽ đảm bảo giá trị được gửi đi dưới dạng số thực mà không quan
// tâm đến thiết lập vùng miền (Locale) của hệ điều hành là gì.

//Tính nhất quán: Dữ liệu được gửi đi dưới dạng tham số (parameterized), giúp tác
// biệt hoàn toàn giữa cấu trúc câu lệnh SQL và giá trị dữ liệu.

import java.sql.*;

public class Kha02 {
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital";
    private static final String USER = "minh";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        int patientId = 101;
        double temp = 37.5;
        int heartRate = 80;

        String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, temp);
            pstmt.setInt(2, heartRate);
            pstmt.setInt(3, patientId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cập nhật chỉ số sinh tồn thành công cho bệnh nhân ID: " + patientId);
            } else {
                System.out.println("Không tìm thấy bệnh nhân có ID: " + patientId);
            }

        } catch (SQLException e) {
            System.err.println("Lỗi thực thi SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

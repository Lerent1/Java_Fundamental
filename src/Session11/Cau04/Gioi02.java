package Session11.Cau04;

// Trong mệnh đề WHERE, biểu thức '1'='1' luôn đúng, nên điều kiện tổng thể cũng đúng với mọi bản ghi.
// Kết quả là hệ thống không còn tìm một bệnh nhân cụ thể nữa mà trả về toàn bộ dữ liệu bệnh nhân,
// gây lộ thông tin bệnh án.
//
//Nguyên nhân chính là do nối chuỗi SQL trực tiếp từ đầu vào người dùng, làm phát sinh lỗ hổng SQL Injection.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Gioi02 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Hospital_DB";
        String user = "minh";
        String password = "12345";

        String patientName = "' OR '1'='1";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM Patients WHERE full_name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, patientName);

            rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("Mã BN: " + rs.getString("patient_id"));
                System.out.println("Họ tên: " + rs.getString("full_name"));
            }

            if (!found) {
                System.out.println("Không tìm thấy bệnh nhân.");
            }

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

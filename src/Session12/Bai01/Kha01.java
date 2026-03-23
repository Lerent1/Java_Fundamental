package Session12.Bai01;

// Cơ chế Pre-compiled (Biên dịch trước): Khi sử dụng PreparedStatement, câu lệnh SQL được gửi
// đến Database engine kèm theo các dấu hỏi chấm (?) làm tham số đại diện. Hệ quản trị CSDL sẽ
// phân tích cú pháp và biên dịch bộ khung của câu lệnh này trước khi dữ liệu thực tế được đưa vào.

//Tách biệt giữa Lệnh và Dữ liệu: Vì cấu trúc câu lệnh đã được "chốt" từ trước, nên các tham số được
// truyền vào sau đó sẽ chỉ được coi là giá trị thuần túy (Literals).

//Vô hiệu hóa mã độc: Ngay cả khi kẻ tấn công nhập vào chuỗi ' OR '1'='1, hệ thống sẽ không thực thi
// đoạn mã đó như một lệnh SQL. Thay vào đó, nó sẽ tìm kiếm trong cột pass một chuỗi ký tự có nội dung
// đúng bằng ' OR '1'='1. Điều này khiến mọi nỗ lực thay đổi cấu trúc câu lệnh đều thất bại.

import java.sql.*;

public class Kha01 {
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital";
    private static final String USER = "minh";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        String code = "DOC001";
        String pass = "mypassword123";

        String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, code);
            pstmt.setString(2, pass);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Lấy tên bác sĩ từ cột "name" trong DB
                    System.out.println("Thành công! Bác sĩ " + rs.getString("name") + " đã đăng nhập.");
                } else {
                    System.out.println("Thông tin đăng nhập không chính xác.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối CSDL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

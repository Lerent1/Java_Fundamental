package Session12.bai03;

// Tại sao bắt buộc phải gọi registerOutParameter()?
//Khai báo kiểu dữ liệu: Khác với các tham số đầu vào (IN) đã biết rõ giá trị,
// các tham số đầu ra (OUT) cần được JDBC Driver biết trước kiểu dữ liệu SQL mà
// Database sẽ trả về. Việc này giúp Driver chuẩn bị bộ nhớ và thực hiện việc chuyển
// đổi (mapping) từ kiểu dữ liệu của Database sang kiểu dữ liệu Java một cách chính xác.
//Thiết lập giao thức: Nếu không đăng ký, khi bạn gọi getDouble(2), JDBC sẽ coi vị trí
// số 2 là không tồn tại hoặc không có quyền truy cập, dẫn đến lỗi "out of range".

//Hằng số tương ứng với kiểu DECIMAL:
//Nếu trong SQL là DECIMAL, trong Java bạn phải đăng ký bằng hằng số: java.sql.Types.DECIMAL.
// (Ngoài ra, Types.NUMERIC cũng thường được sử dụng tương đương).

import java.sql.*;

public class Gioi01 {
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital";
    private static final String USER = "minh";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        int surgeryId = 505;
        String sql = "{call GET_SURGERY_FEE(?, ?)}";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, surgeryId);

            cstmt.registerOutParameter(2, Types.DECIMAL);

            cstmt.execute();

            double totalCost = cstmt.getDouble(2);

            System.out.println("Mã ca phẫu thuật: " + surgeryId);
            System.out.println("Tổng chi phí (bao gồm bảo hiểm): " + totalCost + " VND");

        } catch (SQLException e) {
            System.err.println("Lỗi khi gọi Stored Procedure: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package Session12.Bai04;

// Parsing (Phân tích cú pháp): Kiểm tra xem câu lệnh SQL có đúng cú pháp không.
// Validation (Xác thực): Kiểm tra bảng Results, cột data có tồn tại không, người dùng có quyền ghi không.
// Execution Plan (Lập kế hoạch thực thi): Tìm cách tối ưu nhất để chèn dữ liệu

// Langphi:
//Cả 1.000 câu lệnh thực chất có cùng một cấu trúc (chỉ khác giá trị data). Việc bắt Database phải phân
// tích và lập kế hoạch lại từ đầu cho cùng một việc 1.000 lần là sự lãng phí cực lớn về CPU và Memory.
//Nó giống như việc bạn xây 1.000 ngôi nhà giống hệt nhau nhưng mỗi lần xây lại phải thuê kiến trúc
// sư vẽ lại bản thiết kế từ đầu thay vì dùng chung một bản vẽ.

import java.sql.*;
import java.util.List;

public class Gioi02 {
    public void insertTestResults(List<String> list, Connection conn) {
        String sql = "INSERT INTO Results(data) VALUES (?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (String dataStr : list) {
                pstmt.setString(1, dataStr);

                pstmt.executeUpdate();
            }

            System.out.println("Nạp thành công " + list.size() + " kết quả!");

        } catch (SQLException e) {
            System.err.println("Lỗi thực thi: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

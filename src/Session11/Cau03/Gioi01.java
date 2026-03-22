package Session11.Cau03;

// Phương thức executeUpdate() trả về số dòng bị tác động bởi câu lệnh UPDATE, INSERT hoặc DELETE.
// Nếu giá trị trả về lớn hơn 0 thì có nghĩa là đã có dữ liệu được cập nhật thành công. Ngược lại,
// nếu giá trị trả về bằng 0 thì câu lệnh chạy không lỗi nhưng không có bản ghi nào phù hợp, ví dụ
// mã giường không tồn tại.
//
//Vì vậy, cần kiểm tra giá trị trả về của executeUpdate() để phản hồi chính xác cho y tá. Nếu kết quả
// bằng 0 thì phải thông báo rằng mã giường không tồn tại hoặc không có dữ liệu nào được cập nhật,
// thay vì luôn in ra thông báo thành công gây hiểu lầm.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Gioi01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Hospital_DB";
        String user = "minh";
        String password = "12345";

        String inputId = "Bed_999";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "Occupied");
            ps.setString(2, inputId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật trạng thái giường bệnh thành công.");
            } else {
                System.out.println("Lỗi: Mã giường " + inputId + " không tồn tại.");
            }

        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        } finally {
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

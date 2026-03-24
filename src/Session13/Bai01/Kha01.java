package Session13.Bai01;

// Chế độ Auto-Commit mặc định: Trong JDBC, khi một Connection được khởi tạo,
// nó luôn ở chế độ setAutoCommit(true). Điều này có nghĩa là mỗi khi câu lệnh
// executeUpdate() được gọi, database sẽ ngay lập tức xác nhận (commit) thay đổi
// đó là vĩnh viễn.

//Diễn biến lỗi trong đoạn code:
//Câu lệnh ps1.executeUpdate() chạy thành công
// Database trừ 1 đơn vị thuốc và commit ngay lập tức.
//Dòng code int x = 10 / 0; gây ra lỗi ArithmeticException.
//Chương trình dừng lại và nhảy thẳng xuống khối catch. Câu lệnh ps2.executeUpdate()
// (ghi lịch sử) chưa bao giờ được chạy.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kha01 {
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital";
    private static final String USER = "minh";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver MySQL!");
        }
    }

    public void capPhatThuoc(int medicineId, int patientId) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            String sqlUpdateInventory = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
            ps1 = conn.prepareStatement(sqlUpdateInventory);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            String sqlInsertHistory = "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, NOW())";
            ps2 = conn.prepareStatement(sqlInsertHistory);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println(">>> THÀNH CÔNG: Đã trừ kho và lưu bệnh án.");

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println(">>> THẤT BẠI: Đã Rollback dữ liệu để đảm bảo an toàn.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.err.println("Chi tiết lỗi: " + e.getMessage());
        } finally {
            try {
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Kha01 store = new Kha01();
        store.capPhatThuoc(1, 100);
    }
}
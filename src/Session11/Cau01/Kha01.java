package Session11.Cau01;

// Việc liên tục tạo kết nối đến cơ sở dữ liệu mà không đóng (close) hoặc không quản
// lý tập trung sẽ gây rò rỉ tài nguyên. Sau một thời gian hoạt động, số lượng kết nối
// tăng lên làm database bị quá tải, ứng dụng chậm dần, treo và dễ phát sinh lỗi Communications
// link failure. Đối với hệ thống bệnh viện, đây là rủi ro rất lớn vì phần mềm phải hoạt động ổn
// định 24/7 để phục vụ tra cứu và cập nhật hồ sơ bệnh nhân. Nếu kết nối không được quản lý tốt,
// hệ thống có thể gián đoạn, ảnh hưởng trực tiếp đến công việc của nhân viên y tế và quá trình
// chăm sóc bệnh nhân. Ngoài ra, việc ghi cứng thông tin kết nối trong mã nguồn cũng làm chương
// trình khó bảo trì, khó thay đổi cấu hình và khó kiểm soát lỗi khi nhiều chức năng cùng truy cập
// cơ sở dữ liệu

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Kha01 {
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital";
    private static final String USER = "minh";
    private static final String PASSWORD = "12345";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không tìm thấy MySQL JDBC Driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}

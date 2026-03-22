package Session11.Cau02;

// Lệnh if (rs.next()) chỉ kiểm tra và xử lý một dòng đầu tiên trong ResultSet,
// nên không thể đáp ứng yêu cầu in danh sách tất cả thuốc. Vì vậy chương trình
// chỉ in ra thuốc đầu tiên rồi kết thúc.
//
//Mỗi lần gọi next(), con trỏ của ResultSet sẽ dịch xuống dòng tiếp theo.
// Ban đầu con trỏ đứng trước dòng đầu tiên, sau lần gọi next() đầu tiên
// thì nó mới chuyển đếnbản ghi đầu tiên để đọc dữ liệu.
// Muốn duyệt hết toàn bộ dữ liệu thì phải dùng vòng lặp while (rs.next()).

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Kha02 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Hospital_DB";
        String user = "minh";
        String password = "12345";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            String sql = "SELECT medicine_name, stock FROM Pharmacy";
            rs = stmt.executeQuery(sql);

            System.out.println("=== DANH SÁCH THUỐC TRONG KHO ===");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                String medicineName = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Tên thuốc: " + medicineName + " | Số lượng tồn: " + stock);
            }

            if (!hasData) {
                System.out.println("Kho thuốc hiện đang trống.");
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) stmt.close();
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

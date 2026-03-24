package Session13.Bai02;

// Dữ liệu "treo" (In-flight data): Khi bạn gọi ps1.executeUpdate(),
// dữ liệu đã được gửi đến DB và nằm ở trạng thái "chờ". Nếu gặp lỗi
// ở bước 2 mà bạn chỉ in ra lỗi rồi kết thúc, DB vẫn coi transaction
// đó đang diễn ra. Nó sẽ không biết nên Lưu (Commit) hay Hủy (Rollback).

//Chiếm giữ tài nguyên (Locking): Khi một Transaction chưa kết thúc, Database
// thường sẽ "khóa" (Lock) các dòng dữ liệu liên quan (ví dụ: dòng tiền của bệnh nhân).
// Nếu không có lệnh kết thúc rõ ràng, các giao dịch khác muốn nạp tiền hoặc trừ tiền
// cho bệnh nhân đó sẽ bị chặn (Block), dẫn đến treo hệ thống cục bộ.

// Đó chính là lệnh connection.rollback(). Lệnh này có nhiệm vụ phát tín hiệu cho Database:
// "Có lỗi rồi, hãy hủy bỏ toàn bộ những gì tôi vừa làm ở trên và đưa dữ liệu về trạng thái ban đầu đi!"

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Kha02 {
    private static final String URL = "jdbc:mysql://192.168.1.10:3306/Hospital";
    private static final String USER = "minh";
    private static final String PASSWORD = "12345";

    public void thanhToanVienPhi(int patientId, double amount, String invoiceId) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            conn.setAutoCommit(false);

            String sqlUpdateWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            ps1 = conn.prepareStatement(sqlUpdateWallet);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            String sqlUpdateInvoice = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";
            ps2 = conn.prepareStatement(sqlUpdateInvoice);
            ps2.setString(1, invoiceId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Thanh toán hóa đơn thành công!");

        } catch (SQLException e) {
            System.err.println("Lỗi xảy ra trong quá trình thanh toán: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Hệ thống đã Rollback - Tiền đã được trả lại ví bệnh nhân.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
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
        Kha02 system = new Kha02();

        int patientId = 7;
        double amount = 500000.0;
        String invoiceId = "HD001";

        System.out.println("Bắt đầu thực hiện thanh toán viện phí...");
        system.thanhToanVienPhi(patientId, amount, invoiceId);
    }
}

package Session13.Bai04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rikkei_hospital";
        String user = "minh";
        String password = "123456";

        Gioi02 gioi02 = new Gioi02();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            List<BenhNhanDTO> danhSach = gioi02.getDanhSachDashboard(conn);

            for (BenhNhanDTO benhNhan : danhSach) {
                System.out.println("====================================");
                System.out.println("Mã bệnh nhân: " + benhNhan.getMaBenhNhan());
                System.out.println("Tên bệnh nhân: " + benhNhan.getTenBenhNhan());
                System.out.println("Ngày nhập viện: " + benhNhan.getNgayNhapVien());
                System.out.println("Trạng thái: " + benhNhan.getTrangThai());
                System.out.println("Danh sách dịch vụ:");

                if (benhNhan.getDsDichVu().isEmpty()) {
                    System.out.println("  Chưa có dịch vụ nào");
                } else {
                    for (DichVu dichVu : benhNhan.getDsDichVu()) {
                        System.out.println("  - Mã dịch vụ: " + dichVu.getMaDichVu());
                        System.out.println("    Tên dịch vụ: " + dichVu.getTenDichVu());
                        System.out.println("    Loại: " + dichVu.getLoai());
                        System.out.println("    Thời gian sử dụng: " + dichVu.getThoiGianSuDung());
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
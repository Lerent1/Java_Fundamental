package Session13.Bai03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThanhToanXuatVienService {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdateSoDu = null;
        PreparedStatement pstmtUpdateGiuong = null;
        PreparedStatement pstmtUpdateBenhNhan = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            conn.setAutoCommit(false);

            String sqlSelect = "SELECT so_du_tam_ung, ma_giuong FROM BenhNhan WHERE ma_benh_nhan = ?";
            pstmtSelect = conn.prepareStatement(sqlSelect);
            pstmtSelect.setInt(1, maBenhNhan);
            rs = pstmtSelect.executeQuery();

            if (!rs.next()) {
                throw new Exception("Không tìm thấy bệnh nhân với mã: " + maBenhNhan);
            }

            double soDuTamUng = rs.getDouble("so_du_tam_ung");
            int maGiuong = rs.getInt("ma_giuong");

            if (soDuTamUng < tienVienPhi) {
                throw new Exception("Số dư tạm ứng không đủ để thanh toán viện phí. "
                        + "Số dư hiện tại: " + soDuTamUng + ", viện phí: " + tienVienPhi);
            }

            String sqlUpdateSoDu = "UPDATE BenhNhan SET so_du_tam_ung = so_du_tam_ung - ? WHERE ma_benh_nhan = ?";
            pstmtUpdateSoDu = conn.prepareStatement(sqlUpdateSoDu);
            pstmtUpdateSoDu.setDouble(1, tienVienPhi);
            pstmtUpdateSoDu.setInt(2, maBenhNhan);

            int rowUpdateSoDu = pstmtUpdateSoDu.executeUpdate();

            if (rowUpdateSoDu == 0) {
                throw new Exception("Cập nhật số dư thất bại, không có dòng nào được cập nhật.");
            }

            String sqlUpdateGiuong = "UPDATE GiuongBenh SET trang_thai = 'Trống' WHERE ma_giuong = ?";
            pstmtUpdateGiuong = conn.prepareStatement(sqlUpdateGiuong);
            pstmtUpdateGiuong.setInt(1, maGiuong);

            int rowUpdateGiuong = pstmtUpdateGiuong.executeUpdate();
            if (rowUpdateGiuong == 0) {
                throw new Exception("Giải phóng giường thất bại, không có dòng nào được cập nhật.");
            }

            String sqlUpdateBenhNhan = "UPDATE BenhNhan SET trang_thai = 'Đã xuất viện' WHERE ma_benh_nhan = ?";
            pstmtUpdateBenhNhan = conn.prepareStatement(sqlUpdateBenhNhan);
            pstmtUpdateBenhNhan.setInt(1, maBenhNhan);

            int rowUpdateBenhNhan = pstmtUpdateBenhNhan.executeUpdate();

            if (rowUpdateBenhNhan == 0) {
                throw new Exception("Cập nhật trạng thái bệnh nhân thất bại, không có dòng nào được cập nhật.");
            }

            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công cho bệnh nhân mã: " + maBenhNhan);

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback transaction do xảy ra lỗi.");
                } catch (SQLException rollbackEx) {
                    System.out.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                }
            }
            System.out.println("Xuất viện thất bại: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmtSelect != null) pstmtSelect.close();
                if (pstmtUpdateSoDu != null) pstmtUpdateSoDu.close();
                if (pstmtUpdateGiuong != null) pstmtUpdateGiuong.close();
                if (pstmtUpdateBenhNhan != null) pstmtUpdateBenhNhan.close();

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException closeEx) {
                System.out.println("Lỗi khi đóng tài nguyên: " + closeEx.getMessage());
            }
        }
    }
}

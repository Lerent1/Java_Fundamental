package Session13.Bai04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Gioi02 {
    public List<BenhNhanDTO> getDanhSachDashboard(Connection conn) throws SQLException {
        String sql = """
                SELECT bn.maBenhNhan, bn.tenBenhNhan, bn.ngayNhapVien, bn.trangThai,
                       dv.maDichVu, dv.tenDichVu, dv.loai, dv.thoiGianSuDung
                FROM BenhNhan bn
                LEFT JOIN DichVuSuDung dv ON bn.maBenhNhan = dv.maBenhNhan
                WHERE bn.khoa = ? AND bn.trangThai = ?
                ORDER BY bn.maBenhNhan, dv.thoiGianSuDung
                """;

        Map<String, BenhNhanDTO> mapBenhNhan = new LinkedHashMap<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "CAP_CUU");
            ps.setString(2, "DANG_DIEU_TRI");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String maBenhNhan = rs.getString("maBenhNhan");
                    BenhNhanDTO benhNhan = mapBenhNhan.get(maBenhNhan);

                    if (benhNhan == null) {
                        Timestamp tsNgayNhapVien = rs.getTimestamp("ngayNhapVien");
                        LocalDateTime ngayNhapVien = tsNgayNhapVien != null ? tsNgayNhapVien.toLocalDateTime() : null;

                        benhNhan = new BenhNhanDTO(
                                maBenhNhan,
                                rs.getString("tenBenhNhan"),
                                ngayNhapVien,
                                rs.getString("trangThai")
                        );

                        mapBenhNhan.put(maBenhNhan, benhNhan);
                    }

                    String maDichVu = rs.getString("maDichVu");
                    if (maDichVu != null) {
                        Timestamp tsThoiGian = rs.getTimestamp("thoiGianSuDung");
                        LocalDateTime thoiGianSuDung = tsThoiGian != null ? tsThoiGian.toLocalDateTime() : null;

                        DichVu dichVu = new DichVu(
                                maDichVu,
                                rs.getString("tenDichVu"),
                                rs.getString("loai"),
                                thoiGianSuDung
                        );

                        benhNhan.getDsDichVu().add(dichVu);
                    }
                }
            }
        }

        return new ArrayList<>(mapBenhNhan.values());
    }
}
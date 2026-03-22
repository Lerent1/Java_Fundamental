package Session11.Cau05;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DoctorDAO {
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT doctor_id, full_name, specialty FROM Doctors ORDER BY doctor_id";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getString("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctors.add(doctor);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy danh sách bác sĩ: " + e.getMessage());
        } finally {
            closeResources(conn, ps, rs);
        }

        return doctors;
    }

    public boolean insertDoctor(Doctor doctor) throws Exception {
        String sql = "INSERT INTO Doctors(doctor_id, full_name, specialty) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getDoctorId());
            ps.setString(2, doctor.getFullName());
            ps.setString(3, doctor.getSpecialty());

            return ps.executeUpdate() > 0;
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Mã bác sĩ đã tồn tại.");
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().toLowerCase().contains("data too long")) {
                throw new Exception("Dữ liệu nhập quá dài so với cột trong cơ sở dữ liệu.");
            }
            throw new Exception("Không thể thêm bác sĩ: " + e.getMessage());
        } finally {
            closeResources(conn, ps, null);
        }
    }

    public Map<String, Integer> countBySpecialty() {
        Map<String, Integer> statistics = new LinkedHashMap<>();
        String sql = "SELECT specialty, COUNT(*) AS total FROM Doctors GROUP BY specialty ORDER BY specialty";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                statistics.put(rs.getString("specialty"), rs.getInt("total"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi thống kê chuyên khoa: " + e.getMessage());
        } finally {
            closeResources(conn, ps, rs);
        }

        return statistics;
    }

    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
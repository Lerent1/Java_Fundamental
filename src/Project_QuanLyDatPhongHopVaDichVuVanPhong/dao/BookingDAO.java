package Project_QuanLyDatPhongHopVaDichVuVanPhong.dao;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Booking;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    public boolean isConflict(int roomId, Timestamp start, Timestamp end) {
        String sql = """
            SELECT * FROM bookings
            WHERE room_id = ?
            AND status IN ('PENDING','APPROVED')
            AND (? < end_time AND ? > start_time)
        """;

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, roomId);
            ps.setTimestamp(2, start);
            ps.setTimestamp(3, end);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
            return true;
        }
    }

    public boolean insert(Booking b) {
        String sql = """
            INSERT INTO bookings(user_id, room_id, start_time, end_time, status, preparation_status)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, b.getUserId());
            ps.setInt(2, b.getRoomId());
            ps.setTimestamp(3, Timestamp.valueOf(b.getStartTime()));
            ps.setTimestamp(4, Timestamp.valueOf(b.getEndTime()));
            ps.setString(5, b.getStatus());
            ps.setString(6, b.getPreparationStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
            return false;
        }
    }

    public Booking findById(int id) {
        String sql = "SELECT * FROM bookings WHERE id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return map(rs);
            }

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
        return null;
    }

    public boolean update(Booking b) {
        String sql = """
            UPDATE bookings
            SET status = ?, support_staff_id = ?, preparation_status = ?
            WHERE id = ?
        """;

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, b.getStatus());

            if (b.getSupportStaffId() == 0) {
                ps.setNull(2, Types.INTEGER);
            } else {
                ps.setInt(2, b.getSupportStaffId());
            }

            ps.setString(3, b.getPreparationStatus());
            ps.setInt(4, b.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
            return false;
        }
    }

    public List<Booking> findByUser(int userId) {
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE user_id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(map(rs));
            }

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }

        return list;
    }

    public List<Booking> findByStaffId(int staffId) {
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE support_staff_id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, staffId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(map(rs));
            }

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }

        return list;
    }

    public List<Booking> findPending() {
        List<Booking> list = new ArrayList<>();
        String sql = "SELECT * FROM bookings WHERE status = 'PENDING'";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(map(rs));
            }

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }

        return list;
    }

    private Booking map(ResultSet rs) throws SQLException {
        Booking b = new Booking();

        b.setId(rs.getInt("id"));
        b.setUserId(rs.getInt("user_id"));
        b.setRoomId(rs.getInt("room_id"));
        b.setStartTime(rs.getTimestamp("start_time").toLocalDateTime());
        b.setEndTime(rs.getTimestamp("end_time").toLocalDateTime());
        b.setStatus(rs.getString("status"));
        b.setSupportStaffId(rs.getInt("support_staff_id"));
        b.setPreparationStatus(rs.getString("preparation_status"));

        return b;
    }
}
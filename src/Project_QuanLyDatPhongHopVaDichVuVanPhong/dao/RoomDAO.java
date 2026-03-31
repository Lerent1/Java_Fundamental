package Project_QuanLyDatPhongHopVaDichVuVanPhong.dao;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Room;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public boolean insert(Room room) {
        String sql = "INSERT INTO rooms(room_name, capacity, location) VALUES (?, ?, ?)";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, room.getName());
            ps.setInt(2, room.getCapacity());
            ps.setString(3, room.getLocation());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Insert error: " + e.getMessage());
            return false;
        }
    }

    public List<Room> findAll() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";

        try (Connection conn = JDBCConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("room_name"));
                r.setCapacity(rs.getInt("capacity"));
                r.setLocation(rs.getString("location"));
                list.add(r);
            }

        } catch (Exception e) {
            System.out.println("Find error: " + e.getMessage());
        }
        return list;
    }

    public boolean update(Room room) {
        String sql = "UPDATE rooms SET room_name=?, capacity=?, location=? WHERE id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, room.getName());
            ps.setInt(2, room.getCapacity());
            ps.setString(3, room.getLocation());
            ps.setInt(4, room.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Update error: " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM rooms WHERE id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Delete error: " + e.getMessage());
            return false;
        }
    }

    public Room findById(int id) {
        String sql = "SELECT * FROM rooms WHERE id = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Room r = new Room();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("room_name"));
                r.setCapacity(rs.getInt("capacity"));
                r.setLocation(rs.getString("location"));
                return r;
            }

        } catch (Exception e) {
            System.out.println("FindById error: " + e.getMessage());
        }

        return null;
    }

    public boolean isRoomNameExist(String name) {
        String sql = "SELECT id FROM rooms WHERE room_name=?";
        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            return ps.executeQuery().next();

        } catch (Exception e) {
            return false;
        }
    }
}
package Project_QuanLyDatPhongHopVaDichVuVanPhong.dao;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Equipment;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO {

    // ================= ADD =================
    public boolean insert(Equipment e) {
        String sql = """
            INSERT INTO equipments(name, total_quantity, available_quantity, status)
            VALUES (?, ?, ?, 'Available')
        """;

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setInt(2, e.getTotalQuantity());
            ps.setInt(3, e.getTotalQuantity());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            System.out.println("Insert equipment error: " + ex.getMessage());
            return false;
        }
    }

    // ================= VIEW =================
    public List<Equipment> findAll() {
        List<Equipment> list = new ArrayList<>();
        String sql = "SELECT * FROM equipments";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Equipment e = new Equipment();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setTotalQuantity(rs.getInt("total_quantity"));
                e.setAvailableQuantity(rs.getInt("available_quantity"));
                e.setStatus(rs.getString("status"));

                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ================= UPDATE AVAILABLE =================
    public boolean updateAvailable(int id, int quantity) {

        if (quantity < 0) {
            System.out.println("Số lượng không hợp lệ!");
            return false;
        }

        String sql = """
            UPDATE equipments
            SET available_quantity = ?,
                status = CASE
                    WHEN ? = 0 THEN 'Out of Stock'
                    WHEN ? < total_quantity THEN 'In Use'
                    ELSE 'Available'
                END
            WHERE id = ?
        """;

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, quantity);
            ps.setInt(3, quantity);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Update equipment error: " + e.getMessage());
            return false;
        }
    }

    // ================= DELETE =================
    public boolean delete(int id) {
        String sql = "DELETE FROM equipments WHERE id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Delete equipment error: " + e.getMessage());
            return false;
        }
    }
}
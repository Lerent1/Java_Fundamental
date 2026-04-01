package Project_QuanLyDatPhongHopVaDichVuVanPhong.dao;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Equipment;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO {
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
            System.out.println("Them that bai: " + ex.getMessage());
            return false;
        }
    }

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

    public boolean updateAvailable(int id, int quantity) {
        if (quantity < 0) {
            System.out.println("So luong khong hop le");
            return false;
        }

        Equipment e = findById(id);
        if (e == null) {
            System.out.println("Thiet bi khong ton tai");
            return false;
        }

        if (quantity > e.getTotalQuantity()) {
            System.out.println("So luong con khong duoc lon hon tong");
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

        } catch (Exception e2) {
            System.out.println("Cap nhat that bai: " + e2.getMessage());
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM equipments WHERE id=?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Xoa thiet bi that bai: " + e.getMessage());
            return false;
        }
    }

    public Equipment findById(int id) {
        String sql = "SELECT * FROM equipments WHERE id = ?";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Equipment e = new Equipment();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setTotalQuantity(rs.getInt("total_quantity"));
                e.setAvailableQuantity(rs.getInt("available_quantity"));
                e.setStatus(rs.getString("status"));
                return e;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isNameExist(String name) {
        String sql = "SELECT id FROM equipments WHERE LOWER(name) = LOWER(?)";

        try (Connection conn = JDBCConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            return ps.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
package Project_QuanLyDatPhongHopVaDichVuVanPhong.service;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.EquipmentDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Equipment;

import java.util.List;

public class EquipmentService {
    private final EquipmentDAO dao = new EquipmentDAO();

    public boolean addEquipment(String name, int total) {
        if (total <= 0) {
            System.out.println("Tổng số lượng phải > 0");
            return false;
        }

        Equipment e = new Equipment();
        e.setName(name);
        e.setTotalQuantity(total);

        return dao.insert(e);
    }

    public List<Equipment> getAll() {
        return dao.findAll();
    }

    public boolean updateAvailable(int id, int quantity) {
        return dao.updateAvailable(id, quantity);
    }

    public boolean delete(int id) {
        return dao.delete(id);
    }
}
package Session13.Bai06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private List<Medicine> cart = new ArrayList<>();

    private Medicine findById(String id) {
        for (Medicine m : cart) {
            if (m.getDrugId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }

    public void addMedicine(Medicine medicine) {
        Medicine existing = findById(medicine.getDrugId());

        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + medicine.getQuantity());
            System.out.println("Đã cộng dồn số lượng.");
        } else {
            cart.add(medicine);
            System.out.println("Đã thêm thuốc vào đơn.");
        }
    }

    public void updateQuantity(String id, int newQuantity) {
        Medicine m = findById(id);

        if (m == null) {
            System.out.println("Không tìm thấy thuốc.");
            return;
        }

        if (newQuantity == 0) {
            cart.remove(m);
            System.out.println("Đã xóa thuốc khỏi đơn.");
        } else {
            m.setQuantity(newQuantity);
            System.out.println("Đã cập nhật số lượng.");
        }
    }

    public void removeMedicine(String id) {
        Iterator<Medicine> it = cart.iterator();
        while (it.hasNext()) {
            if (it.next().getDrugId().equalsIgnoreCase(id)) {
                it.remove();
                System.out.println("Đã xóa thuốc.");
                return;
            }
        }
        System.out.println("Không tìm thấy thuốc.");
    }

    public void printInvoice() {
        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc trống.");
            return;
        }

        double total = 0;

        System.out.println("\n===== HÓA ĐƠN =====");
        System.out.printf("%-10s %-20s %-12s %-10s %-12s\n",
                "Mã", "Tên", "Đơn giá", "SL", "Thành tiền");

        for (Medicine m : cart) {
            System.out.println(m);
            total += m.getTotalPrice();
        }

        System.out.printf("TỔNG TIỀN: %.0f VNĐ\n", total);

        // Xóa đơn sau khi in
        cart.clear();
        System.out.println("Đã xóa đơn thuốc sau khi in.");
    }

    public void findCheapMedicines() {
        boolean found = false;

        for (Medicine m : cart) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có thuốc giá dưới 50.000 VNĐ.");
        }
    }
}

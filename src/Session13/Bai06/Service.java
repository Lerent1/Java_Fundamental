package Session13.Bai06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private List<Medicine> cart = new ArrayList<>();
    private Medicine findById(String id) {
        for (int i = 0; i < cart.size(); i++) {
            Medicine m = cart.get(i);
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
            System.out.println("Da cong don so luong.");
        } else {
            cart.add(medicine);
            System.out.println("Da them thuoc vao don.");
        }
    }

    public void updateQuantity(String id, int newQuantity) {
        Medicine m = findById(id);

        if (m == null) {
            System.out.println("Khong tim thay thuoc.");
            return;
        }

        if (newQuantity == 0) {
            cart.remove(m);
            System.out.println("Da xoa thuoc khoi don.");
        } else {
            m.setQuantity(newQuantity);
            System.out.println("Da cap nhat so luong.");
        }
    }

    public void removeMedicine(String id) {
        Iterator<Medicine> it = cart.iterator();
        while (it.hasNext()) {
            if (it.next().getDrugId().equalsIgnoreCase(id)) {
                it.remove();
                System.out.println("Da xoa thuoc.");
                return;
            }
        }
        System.out.println("Khong tim thay thuoc.");
    }

    public void printInvoice() {
        if (cart.isEmpty()) {
            System.out.println("Don thuoc trong.");
            return;
        }

        double total = 0;

        System.out.println("\n===== HOA DON =====");
        System.out.printf("%-10s %-20s %-12s %-10s %-12s\n", "Ma", "Ten", "Don gia", "SL", "Thanh tien");

        for (Medicine m : cart) {
            System.out.println(m);
            total += m.getTotalPrice();
        }

        System.out.printf("TONG TIEN: %.0f VND\n", total);

        cart.clear();
        System.out.println("Da xoa don thuoc sau khi in.");
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
            System.out.println("Khong co thuoc gia duoi 50000 VND.");
        }
    }
}
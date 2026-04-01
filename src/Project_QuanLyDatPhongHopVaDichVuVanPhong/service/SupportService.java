package Project_QuanLyDatPhongHopVaDichVuVanPhong.service;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.BookingDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Booking;

import java.util.List;

public class SupportService {
    private final BookingDAO bookingDAO = new BookingDAO();

    public void showTasks(int staffId) {
        List<Booking> list = bookingDAO.findByStaffId(staffId);

        if (list.isEmpty()) {
            System.out.println("Khong co cong viec");
            return;
        }
        for (Booking b : list) {
            System.out.println("ID: " + b.getId() + " | Status: " + b.getStatus() +
                    " | Prep: " + b.getPreparationStatus()
            );
        }
    }

    public void updateStatus(int bookingId, int staffId, String status) {
        Booking b = bookingDAO.findById(bookingId);

        if (b == null) {
            System.out.println("Khong tim thay booking");
            return;
        }
        if (!b.getStatus().equals("APPROVED")) {
            System.out.println("Chi update booking da APPROVED");
            return;
        }
        if (b.getSupportStaffId() != staffId) {
            System.out.println("Ban khong duoc phan cong booking nay");
            return;
        }

        b.setPreparationStatus(status);
        bookingDAO.update(b);

        System.out.println("Cap nhat thanh cong");
    }

    public List<Booking> getTasks(int staffId) {
        return bookingDAO.findByStaffId(staffId);
    }
}
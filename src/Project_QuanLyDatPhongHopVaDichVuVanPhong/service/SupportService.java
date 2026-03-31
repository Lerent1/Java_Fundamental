package Project_QuanLyDatPhongHopVaDichVuVanPhong.service;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.BookingDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Booking;

import java.util.List;

public class SupportService {
    private final BookingDAO bookingDAO = new BookingDAO();

    public void showTasks(int staffId) {
        List<Booking> list = bookingDAO.findByStaffId(staffId);

        if (list.isEmpty()) {
            System.out.println("Không có công việc");
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
            System.out.println("Không tìm thấy booking!");
            return;
        }

        if (!b.getStatus().equals("APPROVED")) {
            System.out.println("Chỉ update booking đã APPROVED!");
            return;
        }

        if (b.getSupportStaffId() != staffId) {
            System.out.println("Bạn không được phân công booking này!");
            return;
        }

        b.setPreparationStatus(status);
        bookingDAO.update(b);

        System.out.println("Cập nhật thành công!");
    }
}
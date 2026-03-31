package Project_QuanLyDatPhongHopVaDichVuVanPhong.service;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.BookingDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Booking;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class BookingService {
    private final BookingDAO bookingDAO = new BookingDAO();

    public boolean createBooking(Booking b) {
        if (b.getStartTime().isBefore(LocalDateTime.now())) {
            System.out.println("Khong the dat phong trong qua khu");
            return false;
        }

        if (!b.getEndTime().isAfter(b.getStartTime())) {
            System.out.println("Thoi gian ket thuc phai sau thoi gian dat phong");
            return false;
        }

        boolean conflict = bookingDAO.isConflict(
                b.getRoomId(),
                Timestamp.valueOf(b.getStartTime()),
                Timestamp.valueOf(b.getEndTime())
        );

        if (conflict) {
            System.out.println("Bi trung thoi gian dat ");
            return false;
        }

        b.setStatus("PENDING");
        b.setPreparationStatus("PREPARING");

        return bookingDAO.insert(b);
    }

    public List<Booking> getMyBookings(int userId) {
        return bookingDAO.findByUser(userId);
    }
}
package Project_QuanLyDatPhongHopVaDichVuVanPhong.service;

import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.BookingDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.dao.UserDAO;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.model.Booking;
import Project_QuanLyDatPhongHopVaDichVuVanPhong.util.PasswordHash;

public class AdminService {
    private final UserDAO userDAO = new UserDAO();
    private final BookingDAO bookingDAO = new BookingDAO();

    public boolean createSupport(String username, String password) {
        String hash = PasswordHash.hashPassword(password);
        return userDAO.createSupport(username, hash);
    }

    public void approveBooking(int id, int staffId) {
        Booking b = bookingDAO.findById(id);

        if (b == null) {
            System.out.println("Không tìm thấy booking!");
            return;
        }

        if (!b.getStatus().equals("PENDING")) {
            System.out.println("Chỉ duyệt booking PENDING!");
            return;
        }

        b.setStatus("APPROVED");
        b.setSupportStaffId(staffId);

        if (staffId <= 0) {
            System.out.println("Staff ID không hợp lệ!");
            return;
        }

        b.setPreparationStatus("PREPARING");

        bookingDAO.update(b);
        System.out.println("Duyệt thành công!");
    }

    public void rejectBooking(int id) {
        Booking b = bookingDAO.findById(id);

        if (b == null) {
            System.out.println("Không tìm thấy booking!");
            return;
        }

        if (!b.getStatus().equals("PENDING")) {
            System.out.println("Chỉ từ chối booking PENDING!");
            return;
        }

        b.setStatus("REJECTED");
        bookingDAO.update(b);

        System.out.println("Đã từ chối!");
    }

    public java.util.List<Project_QuanLyDatPhongHopVaDichVuVanPhong.model.User> getAllSupport() {
        return userDAO.findSupportUsers();
    }
}
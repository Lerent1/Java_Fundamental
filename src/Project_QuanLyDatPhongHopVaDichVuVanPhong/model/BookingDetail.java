package Project_QuanLyDatPhongHopVaDichVuVanPhong.model;

public class BookingDetail {
    private int id;
    private int bookingId;
    private Integer equipmentId;
    private Integer serviceId;
    private int quantity;

    public BookingDetail(int bookingId, Integer equipmentId, Integer serviceId, int quantity) {
        this.bookingId = bookingId;
        this.equipmentId = equipmentId;
        this.serviceId = serviceId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}

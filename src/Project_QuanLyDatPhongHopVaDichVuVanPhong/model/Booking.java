package Project_QuanLyDatPhongHopVaDichVuVanPhong.model;

import java.time.LocalDateTime;

public class Booking {
    private int id;
    private int userId;
    private int roomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private int supportStaffId;
    private String preparationStatus;

    public Booking(){
    }

    public Booking(int userId, int roomId, LocalDateTime startTime, LocalDateTime endTime, String status, int supportStaffId, String preparationStatus) {
        this.userId = userId;
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.supportStaffId = supportStaffId;
        this.preparationStatus = preparationStatus;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getUserId() {
        return userId;
    }

    public int getSupportStaffId() {
        return supportStaffId;
    }

    public String getPreparationStatus() {
        return preparationStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSupportStaffId(int supportStaffId) {
        this.supportStaffId = supportStaffId;
    }

    public void setPreparationStatus(String preparationStatus) {
        this.preparationStatus = preparationStatus;
    }
}

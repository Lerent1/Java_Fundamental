package Project_QuanLyDatPhongHopVaDichVuVanPhong.model;

public class Equipment {
    private int id;
    private String name;
    private int totalQuantity;
    private int availableQuantity;
    private String status;

    public Equipment() {
    }

    public Equipment(String name, int totalQuantity, int availableQuantity, String status) {
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = availableQuantity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public String getStatus() {
        return status;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }
}

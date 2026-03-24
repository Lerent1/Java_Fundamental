package Session13.Bai04;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanDTO {
    private String maBenhNhan;
    private String tenBenhNhan;
    private LocalDateTime ngayNhapVien;
    private String trangThai;
    private List<DichVu> dsDichVu = new ArrayList<>();

    public BenhNhanDTO() {
    }

    public BenhNhanDTO(String maBenhNhan, String tenBenhNhan, LocalDateTime ngayNhapVien, String trangThai) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.trangThai = trangThai;
        this.dsDichVu = new ArrayList<>();
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public LocalDateTime getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(LocalDateTime ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }

    @Override
    public String toString() {
        return "BenhNhanDTO{" + "maBenhNhan='" + maBenhNhan + '\'' + ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngayNhapVien=" + ngayNhapVien + ", trangThai='" + trangThai + '\'' + ", dsDichVu=" + dsDichVu + '}';
    }
}
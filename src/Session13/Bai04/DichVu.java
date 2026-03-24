package Session13.Bai04;

import java.time.LocalDateTime;

public class DichVu {
    private String maDichVu;
    private String tenDichVu;
    private String loai;
    private LocalDateTime thoiGianSuDung;

    public DichVu() {
    }

    public DichVu(String maDichVu, String tenDichVu, String loai, LocalDateTime thoiGianSuDung) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.loai = loai;
        this.thoiGianSuDung = thoiGianSuDung;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public LocalDateTime getThoiGianSuDung() {
        return thoiGianSuDung;
    }

    public void setThoiGianSuDung(LocalDateTime thoiGianSuDung) {
        this.thoiGianSuDung = thoiGianSuDung;
    }

    @Override
    public String toString() {
        return "DichVu{" + "maDichVu='" + maDichVu + '\'' + ", tenDichVu='" + tenDichVu + '\'' +
                ", loai='" + loai + '\'' + ", thoiGianSuDung=" + thoiGianSuDung + '}';
    }
}
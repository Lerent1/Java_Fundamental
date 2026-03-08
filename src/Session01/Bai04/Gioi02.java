package Session01.Bai04;

import java.io.IOException;

public class Gioi02 {
    public static void saveToFile() throws IOException {
        throw new IOException("Loi khi ghi du lieu vao file!");
    }
    public static void processUserData() throws IOException {
        System.out.println("Dang xu ly du lieu nguoi dung...");
        saveToFile();
    }
    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Da bat loi tai main: " + e.getMessage());
        }
        System.out.println("Chuong trinh tiep tuc chay...");
    }
}

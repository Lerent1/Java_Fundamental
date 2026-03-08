package Session01.Bai06;

import java.io.IOException;

class FileService {
    public static void saveToFile(User user) throws IOException {
        throw new IOException("Khong the ghi du lieu vao file!");
    }

    public static void processUser(User user) throws IOException {
        System.out.println("Dang xu ly du lieu nguoi dung...");
        saveToFile(user);
    }
}

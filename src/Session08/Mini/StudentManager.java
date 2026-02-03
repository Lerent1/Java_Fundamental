package Session08.Mini;

import java.util.Scanner;

public class StudentManager {
    public static Student[] students = new Student[100];
    public static int count = 0;

    public static void deleteStudent(Scanner delete) {
        if (count == 0) {
            System.out.println("Danh sach rong");
            return;
        } else {
            System.out.print("Hay nhap ma sinh vien can xoa: ");
            String id = delete.nextLine();

            int index = -1;
            for (int i = 0; i < count; i++) {
                if (students[i].getIdStudent().equals(id)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Khong tim thay ma sinh vien: " + id);
            } else {
                for (int i = index; i < count - 1; i++) {
                    students[i] = students[i + 1];
                }
                students[count - 1] = null;
                count--;

                System.out.println("Xoa thanh cong");
            }
        }
    }
}

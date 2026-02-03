package Session08.THCaNhan;

import java.util.Scanner;

public class Main {
    static Student[] students = new Student[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner bt = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Quan ly diem sinh vien ===");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo hoc luc");
            System.out.println("4. Sap xep theo diem giam dan");
            System.out.println("5. Thoat");
            System.out.print("Hay nhap lua chon cua ban: ");
            choice = bt.nextInt()

            switch (choice) {
                case 1: {
                    addStudent(bt);
                    break;
                }
                case 2: {
                    show();
                    break;
                }
                case 3:{
                    break;
                }
                case 4: {
                    sapXep();
                    break;
                }
                case 5: {
                    System.out.println("Thoat thanh cong");
                    break;
                }
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 5);
    }

    static void addStudent(Scanner sc) {
        System.out.print("Hay nhap so sinh vien muon them: ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Thong tin sinh vien thu " + (i + 1) + " la: ");
            System.out.print("ID sinh vien la: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Ten sinh vien la: ");
            String name = sc.nextLine();
            System.out.print("Diem sinh vien la: ");
            double score = sc.nextDouble();
            sc.nextLine();
            students[count++] = new Student(id, name, score);
        }
    }

    static void show() {
        if (count == 0) {
            System.out.println("Danh sach rong");
            return;
        } else {
            for (int i = 0; i < count; i++) {
                students[i].display();
            }
        }
    }

    static void sapXep() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student tmp = students[i];
                    students[i] = students[j];
                    students[j] = tmp;
                }
            }
        }
        System.out.println("Sap xep thanh cong");
    }
}

package Session08.Mini;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do{
            System.out.println("-------Quan ly sinh vien--------");
            System.out.println("1.Them sinh vien moi");
            System.out.println("2.Hien thi tat ca sinh vien");
            System.out.println("3.Tim kiem sinh vien");
            System.out.println("4.Cap nhat thong tin sinh vien");
            System.out.println("5.Xoa sinh vien");
            System.out.println("6.Tinh diem trung binh va xep loai");
            System.out.println("7.Xap xep sinh vien");
            System.out.println("8.Thong ke");
            System.out.println("9.Thoat");
            System.out.println("Lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    StudentManager.deleteStudent(sc);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Ban da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }while(choice != 9);
    }
}

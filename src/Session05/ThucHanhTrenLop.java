package Session05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ThucHanhTrenLop {
    public static void main(String[] args) {

        Scanner thucHanh = new Scanner(System.in);
        int choice;

        int max = 100;
        String[] list = new String[max];
        int count = 0;

        Pattern check = Pattern.compile("^B\\d{7}$");

        do {
            System.out.println("\n1. Hien thi danh sach MSSV");
            System.out.println("2. Them MSSV");
            System.out.println("3. Cap nhat MSSV theo index");
            System.out.println("4. Xoa MSSV");
            System.out.println("5. Tim kiem MSSV");
            System.out.println("6. Thoat");
            System.out.print("Hay nhap lua chon cua ban: ");
            choice = thucHanh.nextInt();

            switch (choice) {

                case 1:
                    if (count == 0) {
                        System.out.println("Danh sach rong");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + list[i]);
                        }
                    }
                    break;

                case 2:
                    if (count == max) {
                        System.out.println("Danh sach da day khong the them");
                    } else {
                        int num;
                        System.out.print("Hay nhap so ma sinh vien muon them vao: ");
                        num = thucHanh.nextInt();

                        for (int i = 0; i < num && count < max; i++) {
                            String msv;
                            while (true) {
                                System.out.print("Ma sinh vien thu " + (count + 1) + " la: ");
                                msv = thucHanh.nextLine();

                                if (check.matcher(msv).matches()) {
                                    break;
                                } else {
                                    System.out.println("Sai dinh dang MSSV phai bat dau bang B va co 7 chu so");
                                }
                            }

                            list[count] = msv;
                            count++;
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("Danh sach rong");
                        break;
                    } else {
                        System.out.print("Hay nhap index can sua: ");
                        int index = thucHanh.nextInt();

                        if (index < 0 || index >= count) {
                            System.out.println("Khong hop le");
                            break;
                        }
                        String newMSSV;
                        while (true) {
                            System.out.print("Nhap MSSV moi: ");
                            newMSSV = thucHanh.nextLine();

                            if (check.matcher(newMSSV).matches()) {
                                break;
                            } else {
                                System.out.println("Sai dinh dang");
                            }
                        }
                        list[index] = newMSSV;
                        System.out.println("Cap nhat thanh cong");
                    }
                    break;
                case 4:
                    if (count == 0) {
                        System.out.println("Danh sach rong");
                        break;
                    } else {
                        System.out.print("Hay nhap ma can xoa: ");
                        String deletee = thucHanh.nextLine();

                        int positon = -1;
                        for (int i = 0; i < count; i++) {
                            if (list[i].equals(deletee)) {
                                positon = i;
                                break;
                            }
                        }
                        if (positon == -1) {
                            System.out.println("Khong tim thay");
                            break;
                        }
                        for (int i = positon; i < count - 1; i++) {
                            list[i] = list[i + 1];
                        }

                        list[count - 1] = null;
                        count--;

                        System.out.println("Xoa thanh cong");
                    }
                    break;

                case 5: {
                    if (count == 0) {
                        System.out.println("Danh sach rong");
                        break;
                    } else {
                        System.out.print("HAy nhap chuoi can tim: ");
                        String key = thucHanh.nextLine().toLowerCase();

                        boolean found = false;
                        for (int i = 0; i < count; i++) {
                            if (list[i].toLowerCase().contains(key)) {
                                System.out.println(list[i]);
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Khong tim thay ma");
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("Thoat thanh cong");
                    break;
                }
                default:
                    System.out.println("Lua chon khong hop le, hay chon lai");
            }

        } while (choice != 6);
    }
}
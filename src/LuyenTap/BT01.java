package LuyenTap;

import java.util.Random;

public class BT01 {
    public static void main(String[] args) {
        String name[]  = {
                "Nguyen TUan Minh",
                "Nguyen Tri Thang",
                "Pham Quoc Loc"
        };
        Random randomName = new Random();
        int pick = randomName.nextInt(name.length);
        System.out.println(name[pick]);
    }
}

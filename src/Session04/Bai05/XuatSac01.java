package Session04.Bai05;

import java.util.regex.*;

public class XuatSac01 {
    public static void main(String[] args) {

        String[] logs = {"2024-05-20 | User: NguyenVanA | Action: BORROW | BookID: BK12345"};

        String reg = "(\\d{4}-\\d{2}-\\d{2}) \\| User: (\\w+) \\| Action: (BORROW|RETURN) \\| BookID: (\\w+)";
        Pattern pat = Pattern.compile(reg);

        int borrow = 0;
        int tra = 0;
        for (String log : logs) {
            Matcher matcher = pat.matcher(log);
            if (matcher.find()) {
                String date = matcher.group(1);
                String user = matcher.group(2);
                String action = matcher.group(3);
                String bookId = matcher.group(4);

                System.out.println("Ngay: " + date);
                System.out.println("User: " + user);
                System.out.println("Hanh dong: " + action);
                System.out.println("Ma sach: " + bookId);

                if (action.equals("BORROW")) {
                    borrow++;
                } else if (action.equals("RETURN")) {
                    tra++;
                }
            }
        }

        System.out.println("Tong so luot muon: " + borrow);
        System.out.println("Tong so luot tra: " + tra);
    }
}

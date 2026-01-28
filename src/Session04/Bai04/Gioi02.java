package Session04.Bai04;

import java.util.regex.*;

public class Gioi02 {
    public static void main(String[] args) {
        String cardId = "TV202312345";

        Pattern prefixPattern = Pattern.compile("^TV.*");
        Pattern yearPattern = Pattern.compile("^TV20\\d{2}.*");
        Pattern fullPattern = Pattern.compile("^TV20\\d{2}\\d{5}$");

        Matcher mPrefix = prefixPattern.matcher(cardId);
        Matcher mYear = yearPattern.matcher(cardId);
        Matcher mFull = fullPattern.matcher(cardId);

        if (!mPrefix.matches()) {
            System.out.println("Thieu tien to TV");
        } else if (!mYear.matches()) {
            System.out.println("Năm không hợp lệ");
        } else if (!mFull.matches()) {
            System.out.println("5 ky tu cuoi phai la so");
        } else {
            System.out.println("Ma the hop le");
        }
    }
}

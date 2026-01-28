package Session04.Bai06;

import java.util.regex.*;

public class XuatSac02 {
    public static void main(String[] args) {

        String review = "Cuon sach nay rat te, noi dung that la "
                + " ngu ngoc va khong dang doc";

        String[] blacklist = {"ngu", "te"};

        String regex = "(?i)\\b(" + String.join("|", blacklist) + ")\\b";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(review);

        StringBuffer filteredReview = new StringBuffer();

        while (mat.find()) {
            String badWord = mat.group();
            String stars = "*".repeat(badWord.length());
            mat.appendReplacement(filteredReview, stars);
        }
        mat.appendTail(filteredReview);

        String result = filteredReview.toString();

        if (result.length() > 100) {
            int cutIndex = result.lastIndexOf(" ", 100);
            if (cutIndex == -1) {
                cutIndex = 100;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(result.substring(0, cutIndex));
            sb.append("...");

            result = sb.toString();
        }

        System.out.println("Noi dung sau xu ly:");
        System.out.println(result);
    }
}
package Session04.Bai03;

import java.time.LocalDateTime;

public class Gioi01 {
    public static void main(String[] args) {
        String[] transactions = {"BK001-20/01","BK005-21/01","BK099-22/01"};
        long startBuilder = System.nanoTime();

        StringBuilder strb = new StringBuilder();
        strb.append("Thoi gian he thong: ")
                .append(LocalDateTime.now())
                .append("\n");

        for (String t : transactions) {
            String[] parts = t.split("-");
            strb.append("BookID: ")
                    .append(parts[0])
                    .append(" | Date: ")
                    .append(parts[1])
                    .append("\n");
        }

        String reportBuilder = strb.toString();

        long endBuilder = System.nanoTime();

        System.out.println(reportBuilder);
        System.out.println("Thoi gian dung Builder : " + (endBuilder - startBuilder) + " ns");
    }
}
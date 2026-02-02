package Session07.Bai03;

public class Gioi01 {
    static class ScoreUtils {
        public static boolean checkPass(double score) {
            return score >= 5.0;
        }

        public static double calculateAverage(double[] scores) {
            double sum = 0;
            for (double s : scores) {
                sum += s;
            }
            return sum / scores.length;
        }
    }

    public static void main(String[] args) {
        double[] scores = {6.5, 8.0, 4.5};

        System.out.println("Danh sách điểm: 6.5, 8.0, 4.5");
        System.out.println("\nKết quả xử lý:");

        double avg = ScoreUtils.calculateAverage(scores);
        System.out.printf("Điểm trung bình cả lớp: %.2f\n", avg);

        for (double score : scores) {
            System.out.println(
                    "- Điểm " + score + ": " +
                            (ScoreUtils.checkPass(score) ? "Đạt" : "Trượt")
            );
        }
    }
}

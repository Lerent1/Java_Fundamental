package Session08.THCaNhan;

public class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank() {
        if (score >= 8) {
            return "Gioi";
        } else if (score >= 6.5) {
            return "Kha";
        } else if (score >= 5) {
            return "Trung binh";
        } else {
            return "Yeu";
        }
    }

    public void display() {
        System.out.printf("ID: %d | Ten: %s | Diem: %.2f | Hoc luc: %s", id, name, score, getRank());
    }
}
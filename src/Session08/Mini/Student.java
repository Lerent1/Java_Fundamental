package Session08.Mini;

public class Student {
    private String idStudent;
    private String fullName;
    private int age;
    private String sex;
    private double mathScore;
    private double logicalScore;
    private double chemistryScore;

    public Student(String idStudent, String fullName, int age, String sex, double mathScore, double logicalScore, double chemistryScore) {
        this.idStudent = idStudent;
        this.fullName = fullName;
        this.age = age;
        this.sex = sex;
        this.mathScore = mathScore;
        this.logicalScore = logicalScore;
        this.chemistryScore = chemistryScore;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getLogicalScore() {
        return logicalScore;
    }

    public void setLogicalScore(double logicalScore) {
        this.logicalScore = logicalScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }


}

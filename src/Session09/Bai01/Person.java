package Session09.Bai01;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Họ tên: " + name);
        System.out.println("Tuổi: " + age);
    }
}

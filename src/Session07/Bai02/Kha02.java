package Session07.Bai02;

public class Kha02 {
    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        int a = 10;
        int b = a;

        System.out.println("=== KIEU NGUYEN THUY ===");
        System.out.println("Ban dau: a = " + a + ", b = " + b);

        a = 20;

        System.out.println("Sau khi thay doi a:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Student s1 = new Student("An");
        Student s2 = s1;

        System.out.println("Ban dau:");
        System.out.println("s1.name = " + s1.name);
        System.out.println("s2.name = " + s2.name);

        s1.name = "Binh";

        System.out.println("Sau khi thay doi s1.name:");
        System.out.println("s1.name = " + s1.name);
        System.out.println("s2.name = " + s2.name);
    }
}

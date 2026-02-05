package Session09.Bai04;

public class Gioi02 {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.wagTail();
        }
    }
}

package Session09.Bai02;

public class Animals {
    public void sound() {
        System.out.println("Động vật phát ra âm thanh");
    }

    public static class Dog extends Animals {
        @Override
        public void sound() {
            System.out.println("Cho sua: Gau ggau");
        }
    }

    public static class Cat extends Animals {
        @Override
        public void sound() {
            System.out.println("Meo keu: Mèo méo meo mẹo meo");
        }
    }

}

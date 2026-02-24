package Session10.Bai04;

interface RemoteControl {
    void powerOn();

    default void checkBattery() {
        System.out.println("Pin on dinh");
    }
}

public class Gioi04 {
    public static void main(String[] args) {
        RemoteControl smartLight = new RemoteControl() {

            @Override
            public void powerOn() {
                System.out.println("Den da bat");
            }
        };

        smartLight.powerOn();
        smartLight.checkBattery();
    }
}

package Session08.Bai02;

import java.util.Scanner;

interface TemperatureSensor {
    double getTemperatureCelsius();
}

class OldThermometer {
    public int getTemperatureFahrenheit() {
        return 78;
    }
}

class ThermometerAdapter implements TemperatureSensor {
    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        int f = oldThermometer.getTemperatureFahrenheit();
        return (f - 32) * 5.0 / 9;
    }
}

class Light {
    public void off() {
        System.out.println("FACADE: Tắt đèn");
    }
}

class Fan {
    public void off() {
        System.out.println("FACADE: Tắt quạt");
    }

    public void lowSpeed() {
        System.out.println("FACADE: Quạt chạy tốc độ thấp");
    }
}

class AirConditioner {
    public void off() {
        System.out.println("FACADE: Tắt điều hòa");
    }

    public void setTemperature(int temp) {
        System.out.println("FACADE: Điều hòa set " + temp + "°C");
    }
}

class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner ac;
    private TemperatureSensor sensor;

    public SmartHomeFacade(TemperatureSensor sensor) {
        this.light = new Light();
        this.fan = new Fan();
        this.ac = new AirConditioner();
        this.sensor = sensor;
    }

    public void leaveHome() {
        light.off();
        fan.off();
        ac.off();
    }

    public void sleepMode() {
        light.off();
        ac.setTemperature(28);
        fan.lowSpeed();
    }

    public void getCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.printf("Nhiệt độ hiện tại: %.1f°C\n", temp);
    }
}

public class Kha02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor sensor = new ThermometerAdapter(oldThermometer);

        SmartHomeFacade facade = new SmartHomeFacade(sensor);

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Chế độ rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    facade.getCurrentTemperature();
                    break;
                case 2:
                    facade.leaveHome();
                    break;
                case 3:
                    facade.sleepMode();
                    break;
                case 4:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Không hợp lệ!");
            }
        } while (choice != 4);
    }
}

package Session08.Bai01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HardwareConnection {
    private static HardwareConnection instance;
    private HardwareConnection() {
    }

    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
            System.out.println("HardwareConnection: Đã kết nối phần cứng.");
        }
        return instance;
    }

    public void connect() {
    }

    public void disconnect() {
        System.out.println("HardwareConnection: Đã ngắt kết nối.");
    }
}

interface Device {
    void turnOn();
    void turnOff();
}

class Light implements Device {
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }

    public void turnOff() {
        System.out.println("Đèn: Tắt.");
    }
}

class Fan implements Device {
    public void turnOn() {
        System.out.println("Quạt: Quay.");
    }

    public void turnOff() {
        System.out.println("Quạt: Tắt.");
    }
}

class AirConditioner implements Device {
    public void turnOn() {
        System.out.println("Điều hòa: Bật làm mát.");
    }

    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }
}

abstract class DeviceFactory {
    public abstract Device createDevice();
}

class LightFactory extends DeviceFactory {
    public Device createDevice() {
        System.out.println("LightFactory: Đã tạo đèn mới.");
        return new Light();
    }
}

class FanFactory extends DeviceFactory {
    public Device createDevice() {
        System.out.println("FanFactory: Đã tạo quạt mới.");
        return new Fan();
    }
}

class AirConditionerFactory extends DeviceFactory {
    public Device createDevice() {
        System.out.println("AirConditionerFactory: Đã tạo điều hòa mới.");
        return new AirConditioner();
    }
}

public class Kha01 {
    static Scanner sc = new Scanner(System.in);
    static List<Device> devices = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị mới");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    HardwareConnection.getInstance();
                    break;
                case 2:
                    createDevice();
                    break;
                case 3:
                    controlDevice(true);
                    break;
                case 4:
                    controlDevice(false);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);
    }

    static void createDevice() {
        System.out.println("Chọn loại:");
        System.out.println("1. Đèn");
        System.out.println("2. Quạt");
        System.out.println("3. Điều hòa");
        System.out.print("Chọn: ");
        int type = sc.nextInt();

        DeviceFactory factory = null;

        switch (type) {
            case 1:
                factory = new LightFactory();
                break;
            case 2:
                factory = new FanFactory();
                break;
            case 3:
                factory = new AirConditionerFactory();
                break;
            default:
                System.out.println("Loại không hợp lệ!");
                return;
        }

        Device device = factory.createDevice();
        devices.add(device);
    }

    static void controlDevice(boolean isOn) {
        if (devices.isEmpty()) {
            System.out.println("Chưa có thiết bị nào!");
            return;
        }

        System.out.println("Danh sách thiết bị:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getClass().getSimpleName());
        }

        System.out.print("Chọn thiết bị: ");
        int index = sc.nextInt() - 1;

        if (index < 0 || index >= devices.size()) {
            System.out.println("Không hợp lệ!");
            return;
        }

        if (isOn) {
            devices.get(index).turnOn();
        } else {
            devices.get(index).turnOff();
        }
    }
}

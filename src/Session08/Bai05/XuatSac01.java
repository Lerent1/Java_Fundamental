package Session08.Bai05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

interface Command {
    void execute();
    void undo();
}

class Light {
    public void on() {
        System.out.println("Đèn: Bật");
    }

    public void off() {
        System.out.println("Đèn: Tắt");
    }
}

class Fan {
    public void on() {
        System.out.println("Quạt: Bật");
    }

    public void off() {
        System.out.println("Quạt: Tắt");
    }
}

class AirConditioner {
    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }

    public int getTemperature() {
        return temperature;
    }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}

class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}

class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.off();
    }

    public void undo() {
        fan.on();
    }
}

class ACSetTemperatureCommand implements Command {
    private AirConditioner ac;
    private int newTemp;
    private int prevTemp;

    public ACSetTemperatureCommand(AirConditioner ac, int temp) {
        this.ac = ac;
        this.newTemp = temp;
    }

    public void execute() {
        prevTemp = ac.getTemperature(); // lưu trạng thái cũ
        ac.setTemperature(newTemp);
    }

    public void undo() {
        ac.setTemperature(prevTemp);
        System.out.println("Undo: Điều hòa: Nhiệt độ = " + prevTemp);
    }
}

class RemoteControl {
    private Map<Integer, Command> buttons = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    public void setCommand(int button, Command command) {
        buttons.put(button, command);
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + button);
    }

    public void pressButton(int button) {
        Command cmd = buttons.get(button);
        if (cmd != null) {
            cmd.execute();
            history.push(cmd);
        } else {
            System.out.println("Nút chưa được gán!");
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
        } else {
            System.out.println("Không có lệnh để undo!");
        }
    }
}

public class XuatSac01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        RemoteControl remote = new RemoteControl();

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gán command cho nút");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Chọn nút: ");
                    int btn = sc.nextInt();

                    System.out.println("Chọn command:");
                    System.out.println("1. Bật đèn");
                    System.out.println("2. Tắt đèn");
                    System.out.println("3. Bật quạt");
                    System.out.println("4. Tắt quạt");
                    System.out.println("5. Set nhiệt độ điều hòa");
                    int cmdChoice = sc.nextInt();

                    Command cmd = null;

                    switch (cmdChoice) {
                        case 1:
                            cmd = new LightOnCommand(light);
                            break;
                        case 2:
                            cmd = new LightOffCommand(light);
                            break;
                        case 3:
                            cmd = new FanOnCommand(fan);
                            break;
                        case 4:
                            cmd = new FanOffCommand(fan);
                            break;
                        case 5:
                            System.out.print("Nhập nhiệt độ: ");
                            int temp = sc.nextInt();
                            cmd = new ACSetTemperatureCommand(ac, temp);
                            break;
                        default:
                            System.out.println("Không hợp lệ!");
                    }

                    if (cmd != null) {
                        remote.setCommand(btn, cmd);
                    }
                    break;

                case 2:
                    System.out.print("Nhấn nút: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    remote.undo();
                    break;

                case 4:
                    System.out.println("Thoát!");
                    break;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        } while (choice != 4);
    }
}

package Session08.Bai03;

import java.util.*;

interface Command {
    void execute();
    void undo();
}

class Light {
    public void on() {
        System.out.println("Den: Bat");
    }

    public void off() {
        System.out.println("Den: Tat");
    }
}

class Fan {
    public void on() {
        System.out.println("Quat: Bat");
    }

    public void off() {
        System.out.println("Quat: Tat");
    }
}

class AirConditioner {
    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Dieu hoa: Nhiet do = " + temp);
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
        prevTemp = ac.getTemperature();
        ac.setTemperature(newTemp);
    }

    public void undo() {
        ac.setTemperature(prevTemp);
        System.out.println("Undo: Dieu hoa = " + prevTemp);
    }
}

class RemoteControl {
    private Map<Integer, Command> buttons = new HashMap<>();
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void setCommand(int button, Command command) {
        buttons.put(button, command);
        System.out.println("Gan " + command.getClass().getSimpleName() + " cho nut " + button);
    }

    public void pressButton(int button) {
        Command cmd = buttons.get(button);
        if (cmd != null) {
            cmd.execute();
            undoStack.push(cmd);
            redoStack.clear();
        } else {
            System.out.println("Nut chua duoc gan");
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        } else {
            System.out.println("Khong co lenh undo");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        } else {
            System.out.println("Khong co lenh redo");
        }
    }
}

public class Gioi01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();
        RemoteControl remote = new RemoteControl();

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gan command");
            System.out.println("2. Nhan nut");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Chon nut: ");
                    int btn = sc.nextInt();

                    System.out.println("1. Den bat");
                    System.out.println("2. Den tat");
                    System.out.println("3. Quat bat");
                    System.out.println("4. Quat tat");
                    System.out.println("5. Dieu hoa set nhiet do");
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
                            System.out.print("Nhap nhiet do: ");
                            int temp = sc.nextInt();
                            cmd = new ACSetTemperatureCommand(ac, temp);
                            break;
                    }

                    if (cmd != null) {
                        remote.setCommand(btn, cmd);
                    }
                    break;

                case 2:
                    System.out.print("Nhan nut: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    remote.undo();
                    break;

                case 4:
                    remote.redo();
                    break;

                case 5:
                    System.out.println("Thoat");
                    break;
            }
        } while (choice != 5);
    }
}
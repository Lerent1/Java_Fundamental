package Session08.Bai04;

import java.util.*;

interface Observer {
    void update(int temperature);
}

interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers();
}

class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Cam bien: Nhiet do = " + temp);
        notifyObservers();
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}

class Fan implements Observer {
    public void update(int temp) {
        if (temp < 20) {
            System.out.println("Quat: Nhiet do thap, tu dong TAT");
        } else if (temp <= 25) {
            System.out.println("Quat: Nhiet do vua, chay toc do trung binh");
        } else {
            System.out.println("Quat: Nhiet do cao, chay toc do manh");
        }
    }
}

class Humidifier implements Observer {
    public void update(int temp) {
        System.out.println("May tao am: Dieu chinh do am cho nhiet do " + temp);
    }
}

public class Gioi02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TemperatureSensor sensor = new TemperatureSensor();
        Fan fan = new Fan();
        Humidifier humidifier = new Humidifier();

        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Dang ky quat");
            System.out.println("2. Dang ky may tao am");
            System.out.println("3. Huy dang ky quat");
            System.out.println("4. Huy dang ky may tao am");
            System.out.println("5. Set nhiet do");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sensor.attach(fan);
                    System.out.println("Quat: Da dang ky nhan thong bao");
                    break;
                case 2:
                    sensor.attach(humidifier);
                    System.out.println("May tao am: Da dang ky");
                    break;
                case 3:
                    sensor.detach(fan);
                    System.out.println("Quat: Da huy dang ky");
                    break;
                case 4:
                    sensor.detach(humidifier);
                    System.out.println("May tao am: Da huy dang ky");
                    break;
                case 5:
                    System.out.print("Nhap nhiet do: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;
                case 6:
                    System.out.println("Thoat");
                    break;
            }
        } while (choice != 6);
    }
}

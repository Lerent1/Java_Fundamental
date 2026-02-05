package thucHanh02;

import java.util.Scanner;

public class Machine {
    private String mobel;
    private String manufacturer;
    private int yearOfManufacture;
    private double power;

    public Machine() {

    }

    public Machine(String mobel, String manufacturer, int yearOfManufacture, double power) {
        this.mobel = mobel;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.power = power;
    }

    public String getMobel() {
        return mobel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPower() {
        return power;
    }

    public void setMobel(String mobel) {
        this.mobel = mobel;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void input() {
        Scanner thuchanh = new Scanner(System.in);

        System.out.println("Hay nhap mobel: ");
        mobel = thuchanh.nextLine();


    }
}

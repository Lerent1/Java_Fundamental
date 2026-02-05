package BaitapThucHanh;

import java.util.Scanner;

public class Animal {
    protected String animalName;
    protected int numberOfLegs;
    protected String furColor;
    protected double everageLife;

    public Animal(String animalName, int numberOfLegs, String furColor, double everageLife) {
        this.animalName = animalName;
        this.numberOfLegs = numberOfLegs;
        this.furColor = furColor;
        this.everageLife = everageLife;
    }

    public Animal() {

    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public double everageLife() {
        return everageLife;
    }

    public void everageLife(double everageLife) {
        this.everageLife = everageLife;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten dong vat: ");
        animalName = sc.nextLine();

        System.out.print("Nhap so chan: ");
        numberOfLegs = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap mau long: ");
        furColor = sc.nextLine();

        System.out.print("Nhap tuoi tho trung binh: ");
        everageLife = sc.nextDouble();
    }

    public void display() {
        System.out.println("Ten dong vat: " + animalName);
        System.out.println("So chan: " + numberOfLegs);
        System.out.println("Mau long: " + furColor);
        System.out.println("Tuoi tho trung binh: " + everageLife);
    }
}

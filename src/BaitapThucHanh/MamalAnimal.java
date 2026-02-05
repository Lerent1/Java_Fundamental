package BaitapThucHanh;

import java.util.Scanner;

public class MamalAnimal extends Animal {
    private String foodType;
    private boolean withHuman;
    private String mamalSound;

    public MamalAnimal(String animalName, int numberOfLegs, String furColor,
                       double everageLife, String foodType,
                       boolean withHuman, String mamalSound) {
        super(animalName, numberOfLegs, furColor, everageLife);
        this.foodType = foodType;
        this.withHuman = withHuman;
        this.mamalSound = mamalSound;
    }

    public MamalAnimal() {
        super();
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public boolean isLiveWithHuman() {
        return withHuman;
    }

    public void setLiveWithHuman(boolean withHuman) {
        withHuman = withHuman;
    }

    public String getMamalSound() {
        return mamalSound;
    }

    public void setMamalSound(String mamalSound) {
        this.mamalSound = mamalSound;
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);

        System.out.print("Kieu thuc an: ");
        foodType = sc.nextLine();

        System.out.print("Song voi con nguoi (true/false): ");
        withHuman = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Tieng keu: ");
        mamalSound = sc.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Kieu thuc an: " + foodType);
        System.out.println("Song voi con nguoi: " + withHuman);
        System.out.println("Tieng keu: " + mamalSound);
    }
}
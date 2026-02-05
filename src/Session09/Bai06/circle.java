package Session09.Bai06;

public class circle extends shape {
    private double radius;
    public circle() {
        radius = 1;
    }

    public circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}


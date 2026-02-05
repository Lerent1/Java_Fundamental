package Session09.Bai06;

public class rectangle extends shape {
    private double width;
    private double height;

    public rectangle() {
        width = 1;
        height = 1;
    }

    public rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}


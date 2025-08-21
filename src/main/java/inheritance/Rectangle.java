package inheritance;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    @Override
    public void printInfo() {
        System.out.printf("I'm a rectangle with width %.2f and height %.2f\n", width, height);
    }
}

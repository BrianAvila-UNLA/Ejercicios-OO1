package inheritance;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double calculateArea() {
        return radius * radius * Math.PI;
    }

    public void printRadius() {
        System.out.println("I'm a Circle and my radius is " + radius);
    }
}

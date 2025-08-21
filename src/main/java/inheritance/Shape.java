package inheritance;

public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();

    public void printInfo() {
        System.out.println("I'm a shape and my color is " + color);
    }
}

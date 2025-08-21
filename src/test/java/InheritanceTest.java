import inheritance.*;

import java.util.ArrayList;
import java.util.List;

public class InheritanceTest {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("Red", 1));
        shapes.add(new Rectangle("Green", 3, 4.5d));
        shapes.add(new Rectangle("Blue", 4.7d, 2));

        System.out.println("-- Using polymorphism with inheritance --\n");

        for (Shape shape : shapes) {
            shape.printInfo();
            System.out.println("My area is: " + shape.calculateArea() + "\n");
        }

        System.out.println("-- Let's use 'instanceof' --\n");

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                ((Circle) shape).printRadius();
            }
        }
    }
}

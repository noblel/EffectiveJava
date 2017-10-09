package chapter04.item20.hierarchy;

/**
 * @author Noblel
 */
public class Circle extends Figure {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

package chapter04.item20.hierarchy;

/**
 * @author Noblel
 */
public class Rectangle extends Figure{
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    @Override
    double area() {
        return length * width;
    }
}

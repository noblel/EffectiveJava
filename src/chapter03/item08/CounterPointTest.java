package chapter03.item08;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Noblel
 */
public class CounterPointTest {
    private static final Set<Point> unitCircle;

    static {
        unitCircle = new HashSet<Point>();
        unitCircle.add(new Point(1, 0));
        unitCircle.add(new Point(0, 1));
        unitCircle.add(new Point(-1, 0));
        unitCircle.add(new Point(0, -1));
    }

    public static boolean onUnitCircle(Point point) {
        return unitCircle.contains(point);
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 0);
        Point p2 = new CounterPoint(1, 0);

        // Prints true
        System.out.println(onUnitCircle(p1));

        // Should print true, but doesn't if Point uses getClass-based equals
        System.out.println(onUnitCircle(p2));
    }
}

package chapter03.item08;

/**
 * @author Noblel
 */
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    //违反了对称性
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint))
            return false;
        return super.equals(obj) && ((ColorPoint) obj).color == color;
    }

//    //牺牲了传递性
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//
//        if (!(o instanceof ColorPoint))
//            return o.equals(this);
//
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3),
                p1.equals(p3));
    }
}

package chapter06.item35;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Noblel
 */
public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i /i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {

    }

    @ExceptionTest({ IndexOutOfBoundsException.class,
            NullPointerException.class })
    public static void doublyBad() {
        List<String> list = new ArrayList<String>();
        list.addAll(5, null);
    }
}

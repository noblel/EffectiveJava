package chapter06.item35;

import org.jetbrains.annotations.Contract;

/**
 * @author Noblel
 */
public class Sample {
    @Test
    public static void m1() {
    }

    public static void m2() {
    }

    @Contract(" -> fail")
    @Test //标记注解
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @Test
    public void m5() {
        //实例方法,不是静态方法,所以不属于注解的有效使用
    }

    public static void m6() {
    }

    @Contract(" -> fail")
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }
}

package chapter04.item17;

/**
 * @author Noblel
 *
 * 构造器不能调用可被覆盖的方法,无论是直接调用还是间接调用
 * (因为超类的构造器在子类的构造器之前运行)
 *
 */
public class Super {
    public Super() {
//        overrideMe();
    }

    public void overrideMe() {
    }
}

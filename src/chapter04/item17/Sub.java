package chapter04.item17;

import java.util.Date;

/**
 * @author Noblel
 *
 * clone和readObject都不可以调用覆盖的方法
 * readObject() 覆盖版本的方法将在子类的状态被反序列化之前被运行
 * clone() 覆盖版本的方法则是在子类的clone方法有机会修正被克隆对象的状态之前运行
 */
public final class Sub extends Super{
    private final Date date;

    Sub() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        //没有抛出异常是因为print方法对null进行了处理
        sub.overrideMe();
    }
}

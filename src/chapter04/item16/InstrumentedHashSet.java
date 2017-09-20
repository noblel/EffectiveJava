package chapter04.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 打印结果为6
 * addAll--> super.addAll(HashSet的addAll)--> 覆盖的add方法
 * 三个元素各自调用一次所以加了3
 *
 * @author Noblel
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    /*
    去掉addAll方法可以修正这个子类,但是HashSet的addAll在它的方法上实现的,
    不能保证在java平台的所有实现中保持不变,不能保证版本不同不发生变化
    */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount()); //6
    }
}

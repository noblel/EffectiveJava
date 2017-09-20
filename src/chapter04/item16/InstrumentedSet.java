package chapter04.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 采取复合的方式,不拓展现有类,在新的类中增加一个私有域,引用现有类的一个实例
 * 转发(forwarding)
 *
 * 包装类(不适合在回调框架)
 * Decorator模式
 *
 * @author Noblel
 */
public class InstrumentedSet<E> extends ForwardingSet<E>{
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+= c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedSet<String> s = new InstrumentedSet<String>(
                new HashSet<String>());
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}

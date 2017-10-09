package chapter05.item28;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Noblel
 *
 * 局限性：三个集合的类型必须全部相同
 * 利用有限制的通配符烈性可以使这个方法变得更加灵活
 */
public class Union {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<Integer>();
        integers.add(1);
        integers.add(3);
        integers.add(5);

        Set<Double> doubles = new HashSet<Double>();
        doubles.add(2.0);
        doubles.add(4.0);
        doubles.add(6.0);

        Set<Number> numbers = Union.<Number> union(integers, doubles);
        System.out.println(numbers);
    }
}

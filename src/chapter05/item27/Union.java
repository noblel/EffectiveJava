package chapter05.item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Noblel
 *
 * 局限性：三个集合的类型必须全部相同
 * 利用有限制的通配符烈性可以使这个方法变得更加灵活
 */
public class Union {
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick",
                "Harry"));
        Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe",
                "Curly"));
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}

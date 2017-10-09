package chapter05.item25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Noblel
 *
 * 列表优先于数组
 *
 */
public class Reduction {
    static <E> E reduce(List<E> list, Function<E> f, E initVal) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<E>(list);
        }
        E result = initVal;
        for (E e: snapshot)
            result = f.apply(result, e);
        return result;
    }

    private static final Function<Integer> SUM = new Function<Integer>() {
        @Override
        public Integer apply(Integer arg1, Integer arg2) {
            return arg1 + arg2;
        }
    };

    private static final Function<Integer> PRODUCT = new Function<Integer>() {
        public Integer apply(Integer i1, Integer i2) {
            return i1 * i2;
        }
    };

    private static final Function<Integer> MAX = new Function<Integer>() {
        public Integer apply(Integer i1, Integer i2) {
            return Math.max(i1, i2);
        }
    };

    private static final Function<Integer> MIN = new Function<Integer>() {
        public Integer apply(Integer i1, Integer i2) {
            return Math.min(i1, i2);
        }
    };

    public static void main(String[] args) {
        List<Integer> intLists = Arrays.asList(2, 7, 1, 8, 2, 8, 1, 8, 2, 8);
        System.out.println(reduce(intLists, SUM, 0));
        System.out.println(reduce(intLists, PRODUCT, 1));
        System.out.println(reduce(intLists, MAX, Integer.MIN_VALUE));
        System.out.println(reduce(intLists, MIN, Integer.MAX_VALUE));
    }
}

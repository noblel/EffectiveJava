package chapter05.item23;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Noblel
 */
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings, new Integer(42));//编译错误
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object object) {
        list.add(object);
    }

    //不要使用原始类型的未知类型
    static int rawNumElementInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

    //无限制的通配符类型
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

}

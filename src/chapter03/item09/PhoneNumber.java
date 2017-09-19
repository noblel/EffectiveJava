package chapter03.item09;

import java.util.HashMap;
import java.util.Map;

/**
 * 没有重写hashCode方法会返回null
 * 涉及两个实例,第一个被用于插入HashMap中,第二个用于(试图)获取
 * 由于PhoneNumber没有覆盖hashCode方法从而导致两个相等的实例具有不相等的散列码
 * 两个对象在不同的散列桶中,即使在同一个get方法也会返回null
 * 原因：HashMap有一项优化,可以将每个项相关联的散列码缓存起来,如果散列码不匹配也不必检验对象的等同性
 *
 * 好的散列表：为不相等的对象产生不相等的散列码
 * 理想情况下散列函数应该把集合中不相等的实例均匀的分布到所有可能的散列值上
 *
 * @author Noblel
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) obj;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }


//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + areaCode;
//        result = 31 * result + prefix;
//        result = 31 * result + lineNumber;
//        return result;
//    }

//    private volatile int hashCode;//不可变类,把散列码缓存在对象内部,而不是每次都请求重新计算散列码
//    如果觉得这种类型的对象会被用作key,则就应该在创建的时候计算散列码,否则可以选择延迟初始化
//
//    @Override
//    public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = 17;
//            result = 31 * result + areaCode;
//            result = 31 * result + prefix;
//            result = 31 * result + lineNumber;
//            hashCode = result;
//        }
//        return result;
//    }


    //虽然确保了散列码相等,但是每个对象都映射到同一个散列桶中,使散列表退化为链表
//    @Override
//    public int hashCode() {
//        return 42;
//    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}

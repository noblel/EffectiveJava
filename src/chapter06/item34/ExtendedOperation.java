package chapter06.item34;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Noblel
 * 虽然无法实现可拓展的枚举类型
 * 可以通过编写接口以及实现该接口的基础枚举类型,对它进行模拟
 */
public enum ExtendedOperation implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(ExtendedOperation.class, x, y);
        System.out.println();
        test2(Arrays.asList(ExtendedOperation.values()), x, y);
    }


    //确保Class对象既是枚举又是Operation的子类型
    private static <T extends Enum<T> & Operation> void test(Class<T> opSet,
                                                             double x, double y) {
        for (Operation op : opSet.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

    //除非需要灵活的合并多个实现类型的操作,否则可能最好使用有限制的类型令牌
    private static void test2(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}

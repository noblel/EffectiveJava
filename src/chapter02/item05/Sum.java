package chapter02.item05;

/**
 * @author Noblel
 */
public class Sum {
    public static void main(String[] args) {
        //变量声明为Long而不是long 意味着程序构造大约2^31个多余Long实例
        //优先使用基本类型而不是装箱类型
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

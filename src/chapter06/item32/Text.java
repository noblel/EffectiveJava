package chapter06.item32;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author Noblel
 *         使用枚举代替int常量，内部实现就是位运算如果美剧类型有64个或者更少
 *         整个EnumSet就是单个long来表示的，removeAll就是用位运算实现的
 *         <p>
 *         EnumSet有个缺点,无法创建不可变的EnumSet可以用Collections.unmodifiableSet()封装
 *         但是简洁和性能受到影响
 */
public class Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    //最好接受接口类型而非实现类型
    public void applyStyles(Set<Style> styles) {
    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}

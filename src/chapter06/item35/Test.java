package chapter06.item35;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Noblel
 */
@Retention(RetentionPolicy.RUNTIME) //元注解,运行时保留
@Target(ElementType.METHOD) //只有在方法中声明才是合法的
public @interface Test {
}

package chapter04.item19;

/**
 * @author Noblel
 *         <p>
 *         <p>
 *         如果常量和某些类或者接口紧密相关应该添加到这个类或者接口中
 *         比如Integer的MIN_VALUE等
 *         如果这些常量最好被看作枚举类型，那就用枚举类
 *         否则应该使用不可实例化的工具类
 */
public class PhysicalConstants {
    private PhysicalConstants() {
    }

    public static final double AVOGADROS_NUMBER = 6.02214199e23;

    public static final double BOLTZMANN_CONSTANT = 1.3806503e-23;

    public static final double ELECTRON_MASS = 9.10938188e-31;
}

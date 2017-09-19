package chapter02.item03.enumoration;

/**
 * 单元素的枚举类型是实现单例的最佳方法
 *
 * @author Noblel
 */
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

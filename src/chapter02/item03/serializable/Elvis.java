package chapter02.item03.serializable;

/**
 * @author Noblel
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    //防止每次反序列化一个序列化实例产生一个新的实例
    private Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}

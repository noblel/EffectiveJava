package chapter06.item33;

import java.util.*;

/**
 * @author Noblel
 * 数组不能与泛型兼容,程序需要进行未受检的转换
 */
public class Herb {
    public enum Type {
        //一年生植物,多年生植物,两年生植物
        ANNUAL, PERENNIAL, BIENNIAL
    }

    private final String name;
    private final Type type;

    public Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Herb[] garden = {new Herb("Basil", Type.ANNUAL),
                new Herb("Carroway", Type.BIENNIAL),
                new Herb("Dill", Type.ANNUAL),
                new Herb("Lavendar", Type.PERENNIAL),
                new Herb("Parsley", Type.BIENNIAL),
                new Herb("Rosemary", Type.PERENNIAL) };

        Map<Type, Set<Herb>> herbsByType = new EnumMap<Type, Set<Herb>>(Type.class);

        for (Type type : Type.values()) {
            herbsByType.put(type, new HashSet<Herb>());
        }

        for (Herb herb : garden) {
            herbsByType.get(herb.type).add(herb);
        }

        System.out.println(herbsByType);
    }
}

package chapter04.item18;

import java.util.Map;

/**
 * @author Noblel
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Map.Entry))
            return false;
        Map.Entry<?, ?> arg = (Map.Entry<?, ?>) obj;
        return equals(getKey(), arg.getKey())
                && equals(getValue(), arg.getValue());
    }

    private static boolean equals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    @Override
    public int hashCode() {
        return hashCode(getKey()) ^ hashCode(getValue());
    }

    private static int hashCode(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }
}

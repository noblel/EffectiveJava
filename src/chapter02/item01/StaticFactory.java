package chapter02.item01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Noblel
 */
public class StaticFactory {

    //Map<String, List<String>> map = new HashMap<String, List<String>>();
    Map<String, List<String>> map = newInstance();

    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<K, V>();
    }

}

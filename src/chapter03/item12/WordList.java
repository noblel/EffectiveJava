package chapter03.item12;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Noblel
 */
public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<String>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
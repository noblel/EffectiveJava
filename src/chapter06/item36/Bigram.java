package chapter06.item36;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Noblel
 */
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /*
    本想覆盖equals方法,但是参数不是Object的
     */

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bigram))
            return false;
        Bigram b = (Bigram) obj;
        return b.first == first && b.second == second;
    }

//    public boolean equals(Bigram b) {
//        return b.first == first && b.second == second;
//    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<Bigram>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size());
    }
}

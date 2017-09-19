package chapter02.item05.slowversion;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Noblel
 */
public class Person {
    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = new Date(birthDate.getTime());
    }

    //isBabyBoomer每次调用的时候都会创建一个Calendar,一个TimeZone和两个Date实例
    public boolean isBabyBoomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0
                && birthDate.compareTo(boomEnd) < 0;
    }
}

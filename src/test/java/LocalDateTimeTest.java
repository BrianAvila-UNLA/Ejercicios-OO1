import localdatetime.DatesAndTimes;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDateTimeTest {

    public static void main(String[] args) {
        DatesAndTimes d = new DatesAndTimes(LocalDate.now(), LocalTime.of(23, 50, 13));

        System.out.println("-- Before adding 60 hours and 40 days --\n");
        System.out.println(d);

        d.addDays(40);
        d.addHours(60);

        System.out.println("\n-- After adding 60 hours and 40 days --\n");
        System.out.println(d);
    }
}

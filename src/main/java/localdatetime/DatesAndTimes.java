package localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DatesAndTimes {
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;

    public DatesAndTimes(LocalDate localDate, LocalTime localTime) {
        this.localDate = localDate;
        this.localTime = localTime;
        localDateTime = LocalDateTime.of(localDate, localTime);
    }

    public void addDays(int days) {
        localDate = localDate.plusDays(days);
    }

    public void addHours(int hours) {
        localTime = localTime.plusHours(hours);
    }

    @Override
    public String toString() {
        return "DatesAndTimes{" +
                "localDate=" + localDate +
                ", localTime=" + localTime +
                '}';
    }
}

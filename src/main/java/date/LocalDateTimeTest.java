package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {

    public static void main(String[] args) {
        var localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        var localDate2 = LocalDateTime.of(2022, Month.NOVEMBER, 24, 23, 46, 22, 444949495);
        System.out.println(localDate2);

        var localDate3 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        localDate3 = localDate3.plusDays(24);
    }
}

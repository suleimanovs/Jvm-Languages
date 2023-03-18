package date;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateTest {

    public static void main(String[] args) {
        var localDate = LocalDate.now();
        System.out.println(localDate); //YYYY-MM-DD

        var localDate2 = LocalDate.of(2022, Month.NOVEMBER, 24);
        System.out.println(localDate2);


        localDate2 = localDate.plusDays(12);
        localDate2 = localDate.minusDays(4);
        System.out.println(localDate2);


        localDate2 = localDate.plusWeeks(12);
        localDate2 = localDate.minusWeeks(7);
        System.out.println(localDate2);

        localDate2 = localDate.plusMonths(12);
        localDate2 = localDate.minusMonths(44);
        System.out.println(localDate2);

        localDate2 = localDate.plusYears(12);
        localDate2 = localDate.minusYears(12);
        System.out.println(localDate2);
    }
}

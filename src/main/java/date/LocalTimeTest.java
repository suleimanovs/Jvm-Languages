package date;

import java.time.*;

public class LocalTimeTest {

    public static void main(String[] args) {
        var localTime = LocalTime.now();
        System.out.println(localTime); //hh:mm:ss.nano

        var localTime2 = LocalTime.of(23, 46, 22, 444949495);
        System.out.println(localTime2);

        localTime2 = localTime2.plusHours(12);
        localTime2 = localTime2.plusMinutes(12);
        localTime2 = localTime2.plusSeconds(12);
        localTime2 = localTime2.plusNanos(454545445654654612L);
    }
}

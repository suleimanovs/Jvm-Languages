package cycle;


class WhileExpression {

    public static void main(String[] args) {
        alarm(13,13);
    }

    /**
     * способ с помощью expression-ов, этот способ более правильный и рекомендуемый
     */
    public static void alarm(int h, int m) {


        int hour = 0;

        OUTER:
        do {
            int minute = 0;

            while (minute < 60) {
                minute++;
                System.out.println(hour + " : " + minute);


                if (hour == h && minute == m) {
                    System.out.println("Будильник звенит!");
                    break OUTER;// этот break остановит внешний loop
                }

            }
            hour++;

        } while (hour < 24);


    }


}

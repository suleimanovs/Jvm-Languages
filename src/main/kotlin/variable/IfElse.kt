package variable


fun main() {

    /**
     * В котлин операттр if-else являются не только конструкциями , но еще и выражением( они могут вернуть значение).
     * Так же есть поддержка интервалов
     *
     */

    val string = "String"

    /**
     * Обратите внимание, что в Kotlin оператор if является выражением, возвращающим значение.
     * Это похоже на тернарный оператор в Java: (а > Ь) ? а : Ь.
     */
    val isLarge = if (string.length in 5..10) "yes" else "no"

    // java version
    /**
     *            String string = "String";
     *            int length = string.length();
     *            String isLarge;
     *            if (5 <= length) {
     *                if (10 >= length) {
     *                    isLarge = "yes";
     *                    }
     *            }else {
     *                isLarge = "no";
     *            }
     */

}
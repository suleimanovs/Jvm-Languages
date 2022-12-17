package variable


fun main() {

    /**
     * Переменным объявленным с ключевым словом var можно присвоить новое значение. Но, новое значение должно бы быть
     * соответствующего типа.
     * Аналог в Java будет:
     *    int twenty = 12;
     *    List<String> list = new ArrayList<String>();
     */
    var twenty = 12
    var list = mutableListOf<String>()
    twenty = 13
    list = mutableListOf()
    // error: twenty = 's'


    /**
     * Чтобы объявить переменную, доступную только для чтения, используется ключевое слово val.
     * Аналог в Java будет:
     * final int thirty = 13;
     * final List<Integer> ints = new ArrayList<>();
     */
    val thirty = 13
    val ints = mutableListOf<Int>()
    // error: thirty = 14
    // error: thirty = 13
    // error: ints = mutableListOf<Int>()

}
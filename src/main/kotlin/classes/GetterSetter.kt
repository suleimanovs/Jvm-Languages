package classes


class SomeClass {

    /**
     * Если поле объявлен как val(только для чтения), то для него не доступен setter.
     * После компиляции будет создан метод getName(), по этому в коде мы не можем объявить функцию
     * с таким названием и возвращаемым типом
     * [field] это текущее значение(поле) на которое ссылается field
     * Декомпилированный код на Java :
     *
     *    @NotNull private final String name = "SomeClass";

     *    @NotNull
     *    public final String getName() {
     *       return StringsKt.capitalize(this.name);
     *    }
     */
    val name = "SomeClass"
        get() = field.capitalize()

    //fun getName(): String { так объявить
    //}                       не можем

    /**
     * Объявить можно и так, каждый раз когда мы обратимся к данной переменной, что бы получить значение,
     * мы получим 12
     * Декомпилированный код на Java :
     *
     *    public final int getAge() {
     *       return 12;
     *       }
     * Как мы видим, то для [age] не было сгенерировано поле(переменная), так как она сразу возвращает в геттере
     */
    val age get() = 12


    /**
     * Если поле объявлен как var(для чтения  и записи), то для него доступен и setter и геттер
     * При компиляции будут созданы методы getAddress(),setAddress по этому в коде мы не можем объявить функции
     * с такими названиеми и параметром, возвращаемым типом
     * [value] это новое значение которую мы будем класть
     *
     *    @NotNull private String address = "Moscow";
     *
     *    @NotNull
     *    public final String getAddress() {
     *       String var1 = this.address.toUpperCase();
     *       Intrinsics.checkNotNullExpressionValue(var1, "this as java.lang.String).toUpperCase()");
     *       return var1;
     *    }
     *    public final void setAddress(@NotNull String value) {
     *       Intrinsics.checkNotNullParameter(value, "value");
     *       CharSequence var2 = (CharSequence)value;
     *       if (!StringsKt.isBlank(var2)) {
     *          this.address = value;
     *       } else {
     *          this.address = "Moscow";
     *       }
     *    }
     *
     */
    var address = "Moscow"
        get() = field.toUpperCase()
        set(value) = if (value.isNotBlank()) field = value else field = "Moscow"

//  fun setAddress(new: String) {} так объявить мы не можем,

//  fun getAddress(): String {}  эти методы и так будут созданы. Можно кстати по рефлексии проверить


    /**
     * для setter - можно ставить всякие ограничения видимости. В данной реализаций класть новое значение в переменную
     * может только то  класс в котором объявлен переменная [profession]
     *
     *  @NotNull private String profession = "Programmer";
     *
     *  @NotNull
     *  public final String getProfession() {
     *     String profession = this.profession.toUpperCase();
     *     Intrinsics.checkNotNullExpressionValue(profession, "this as java.lang.String).toUpperCase()");
     *     return profession;
     * }
     * Как видим, метод  setProfession не был сгенерирован, так как для внешнего мира, сеттер не понадобится,
     * ведь она приватная
     */
    var profession = "Programmer"
        get() = field.toUpperCase()
        private set


    init {
        /**
         * Из вне менять мы не сможем
         */
        profession = "Cooker"
    }
}
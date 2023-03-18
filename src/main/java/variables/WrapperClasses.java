package variables;

public class WrapperClasses {


     /**
     * Wrapper классы, это классы обертки для примитивных типов данных, они содержат в себе значение
      * примитивных типов данных, основная причина их создания были джинерики (обобщения), так как джинерики не способны
      * работать с примитивами. У wrapper классов переопределен метод equals
     */
    public static void main(String[] args) {

        /**
         * Для Wrapper классов доступна autoboxing.
         * Autoboxing - это конвертирование примитивных типов данных в соответствующий wrapper класс.
         * Unboxing - это конвертирование объекта типа wrapper класс в соответствующий примитивный тип данных
         */
        int intPrimitive = 123;
        Integer intWrapper = intPrimitive; // autoboxing
        intPrimitive = intWrapper; //unboxing


        /**
         * У всех wrapper классов есть метод parse(), позволяет конвертировать значение типа данных String,
         * в соответствующий примитивный тип данных
         */
        Boolean bool = Boolean.parseBoolean("true");
        Double aDouble = Double.parseDouble("1.4");

        Integer integer = Integer.valueOf("123");


    }
}

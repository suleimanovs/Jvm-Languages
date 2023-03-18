package generics;


import java.util.ArrayList;

/**
 * Type Erasure - стирание типов, при runtime вся информация о generics удаляется, то есть информацию о generics знает
 * только компилятор для необходимых проверок. Везде где есть параметризованные типы заменяются на Object. И привидение
 * типов снова возвращаются. То есть дженнерики это только на синтаксисе во и во времени компиляций
 */
public class TypeErasure {

    public static void main(String[] args) {

        var array= new ArrayList<Integer>();
        /**
         * Jvm видит это так, то есть для него это список Object, а при вызове метода get() например, проиcходит casting
         */
        var array0 = new ArrayList<>();

    }

    /**
     * Так объявить мы не можем, это не перезагрузка методов для Jvm. Она обеих видит так:
     * <pre>@code{
     *     void abc(ArrayList list){
     *
     *     }
     * }</pre>
     *
     * то есть тип стирается
     */
//    void abc(ArrayList<String> list){
//        System.out.println(list);
//    }
//
//    void abc(ArrayList<Integer> list){
//        System.out.println(list);
//    }
}


class Parent{
    void abc(ArrayList<Integer> list){
        System.out.println(list);
    }
}

class Child extends Parent{

    /**
     * Несмотря на то, что Jvm видит параметры метода так:
     * void abc(ArrayList list), компилятор не позволит нам например вместо Integer указать String. Так как
     * компилятор понимает что при кастинге будут проблемы
     * */
    void abc(ArrayList<Integer> list){
        System.out.println(list);
    }
}
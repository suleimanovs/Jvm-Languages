package generics;


import java.util.ArrayList;

/**
 * Type Erasure - стирание типов, при runtime вся информация о generics удаляется, то есть информацию о generics знает
 * только компилятор для необходимых проверок
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
     * Так об явить мы не можем, это не перезагрузка методов для Jvm. Она обеих видит так:
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
     * несмотря на то что Jvm видит парметры метода так:
     * void abc(ArrayList list), компилятор не позволит нам напрмиер вместо Integer указать String. Так как
     * компилятор понимает что при кастинге будут проблемы
     * */
    void abc(ArrayList<Integer> list){
        System.out.println(list);
    }
}
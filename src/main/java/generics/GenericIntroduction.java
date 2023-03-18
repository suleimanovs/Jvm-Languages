package generics;

import java.util.ArrayList;

public class GenericIntroduction {

    public static void main(String[] args) {

        /**
         * без дженнериков мы бы могли добавить в лист объект любого типа, что является не правильным.
         */
        var list = new ArrayList<>();

        list.add(12);
        list.add(12.3f);
        list.add("Mettlesome");
        list.add(new StringBuffer());


        /**
         * Причины создания Generics в Java:
         * 1. Typ Safe - тип безопасность. Мы можем обнаружить ошибки типа на уровне компиляций
         * 2. Reusable Code - то есть он позволяет нам не создавать дублированные код, методы для каждого типа отдельно
         */
        var listString = new ArrayList<String>();
        listString.add("Text1");
        listString.add("Text2");
        listString.add("Text3");
        // listString.add(12); ошибка, класть можно только String

    }

}

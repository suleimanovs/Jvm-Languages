package clazz.nested;

public class LocalInnerClass {

}

/**
 * • Local inner класс располагается в блоках кода таких, как, например, метод или конструктор
 * • Local inner класс не может быть static
 * • Область видимости local inner класса – это блок, в котором он находится
 * • Local inner класс может обращаться даже к private элементам внешнего класса
 * • Local inner класс может обращаться к элементам блока, в котором он написан при условии, что они final или effectively final
 */

class Local {

    void local() {
        class Math {
            int a = 12;
        }

        var math = new Math();
        System.out.println(math.a);
    }

}
package annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Annotation - это специальные комментарий, метки, метаданные которые нужны для передачи определенной информаций.
 * Можно наделить аннотацией интерфейс, класс, метод, переменную т.д.
 *<p>
 * @Target - показывает область кода, к которой Аннотация может быть применима. Самые распространённые области кода:
 * • TYPE – class, interface, enum;
 * • FIELD – поле класса;
 * • METHOD – метод класса;
 * • PARAMETER – параметры метода или конструктора
 * <p>
 * То есть что бы сделать нашу аннотацию специфическим, конкретным только для определенного участки кода, нужно наделить ее
 * другой аннотацией которая называется @Target
 * @Retention описывает жизненный циклАннотации
 * • SOURCE – Аннотация видна в source коде, отбрасывается компилятором и уже в byte коде не видна (например Override)
 * • CLASS – Аннотация видна в byte коде, отбрасывается JVM во время выполнения программы;
 * • RUNTIME – Аннотация видна во время выполнения программ
 */

@Target({ElementType.FIELD, ElementType.METHOD}) // можно использовать только для поля и метода
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    /**
     * Переменные в аннотациях обь являются именно так, с круглыми скобками в конце, и еще можно указать им
     * значения по умолчанию:
     */
    String OS() default "Android";

    int yearOfCompanyCreation() default 2000;
}

@SmartPhone(yearOfCompanyCreation = 2010)
class Xiaomi {
    String model;
    int price;
}


@SmartPhone(OS = "iOS", yearOfCompanyCreation = 1976)
class iPhone {
    String model;
    int price;
}

public class Annotation {
    public static void main(String[] args) {

        /**
         * попробуем прочесть данные из классов ою аннотаций с помощью реффлексий
         */

        Class<Xiaomi> xiaomiClass = Xiaomi.class;
        SmartPhone xiaomiAnnotation = xiaomiClass.getAnnotation(SmartPhone.class);
        System.out.println("OS of Xiaomi: " + xiaomiAnnotation.OS());
        System.out.println("Years of company Xiaomi: " + xiaomiAnnotation.yearOfCompanyCreation());
    }
}
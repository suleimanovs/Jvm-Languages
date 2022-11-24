package variables;

import java.util.Objects;

/**
 * Created by Osman on 11:29 AM
 */
public class HashcodeEquals {

    public static void main(String[] args) {

    }

    static class Person {

        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }


        /**
         * Правила для методов equals и hashcode:
         * 1.Переопределил equals - переопредели и hashcode
         * 2.Если хэш-коды двух обьектов разные, то и обьекты точно разные.
         * 3.Если хэш-коды двух обьетов одинаковы, то это не значит что и обьекты тоже равные,
         * хэш-коды могут просто совпасть(коллизия).
         */

        /**
         * Метод equals принадлежит классу Object. Дефолтная реализация данного метода сравнивает ссылки двух объектов,
         * то есть по умолчанию что оператор сравнения == что метод equals делают одно и тоже, сравнивают ссылки.
         * Дефолтная реализация метода equals:
         *  <pre>{@code
         *
         *  public boolean equals(Object obj) {
         *         return (this == obj);
         *     }
         *
         *  }</pre>
         *
         *
         */
        @Override
        public boolean equals(Object o) {
            //если оба ссылаются на один и тот же объект, то они равные, возвращаем true
            if (this == o) return true;
            //если объект с которым сравниваем, является null, или это вообще другой класс (не Person), то возвращаем false
            if (o == null || getClass() != o.getClass()) return false;
            // приводим этот Object к типу Person
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }


        /**
         * Метод toString принадлежит классу Object, возвращает строковое представление объекта. Дефолтная реализация
         * данного метода возвращает имя класса + @ + число (результат метода hashcode данного объекта)
         */
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }




}

package oop.modifications;

/**
 * Created by Osman on 7:50 PM
 */
public class Main {

    /**
     * @modificaton private - переменные и методы класса доступны только в самом классе
     */

    public static void main(String[] args) {
        MyThread man1 = new MyThread("Osman",19,356);
        /**
         * переменные внутри класса(поля) отмеченные модефикатором private
         * не доступны для обьекта,то есть не доступен для man1
         */
       // man1.age - не доступно
        man1.setAge(12);


    }
}

























/*

    int num1 = 12;
    float num2 = 12.45635636f;
    boolean isChrthrthrthrteck = true;*/

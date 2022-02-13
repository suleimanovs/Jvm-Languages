package oop.interfaceoop.listAnimal;

import oop.interfaceoop.abstractAnimal.Animal;
import oop.interfaceoop.interfaceAnimal.Flyable;

/**
 * Created by Osman on 14:44
 */
public class Bird extends Animal implements Flyable {
    @Override
    public void eat() {
        System.out.println("Птичий корм");

    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

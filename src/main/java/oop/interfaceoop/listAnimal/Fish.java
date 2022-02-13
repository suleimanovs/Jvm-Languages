package oop.interfaceoop.listAnimal;

import oop.interfaceoop.abstractAnimal.Animal;
import oop.interfaceoop.interfaceAnimal.Swimmable;

/**
 * Created by Osman on 14:44
 */
public class Fish extends Animal implements Swimmable {
    @Override
    public void eat() {
        System.out.println("Рыбий корм");
    }

    @Override
    public void swim() {
        System.out.println("I can swim");
    }
}
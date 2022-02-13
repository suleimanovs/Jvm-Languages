package oop.interfaceoop.listAnimal;

import oop.interfaceoop.abstractAnimal.Animal;
import oop.interfaceoop.interfaceAnimal.RunAnimal;

/**
 * Created by Osman on 14:44
 */
public class Dog extends Animal implements RunAnimal {
    @Override
    public void eat() {
        System.out.println("Кость");
    }

    @Override
    public void run() {
        System.out.println("Собака бежит");
    }
}
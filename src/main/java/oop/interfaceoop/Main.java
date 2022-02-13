package oop.interfaceoop;

import oop.interfaceoop.interfaceAnimal.RunAnimal;
import oop.interfaceoop.listAnimal.Cat;
import oop.interfaceoop.listAnimal.Dog;

/**
 * Created by Osman on 11:21
 */
public class Main {

    public static void main(String[] args) {
        RunAnimal[] runAnimals = {
                new Cat(),
                new Cat(),
                new Cat(),
                new Cat(),
                new Cat(),
                new Dog(),
                new Dog(),
                new Dog(),
                new Dog(),
                new Dog()
        };

        for (RunAnimal runAnimal : runAnimals) runAnimal.run();




    }
}

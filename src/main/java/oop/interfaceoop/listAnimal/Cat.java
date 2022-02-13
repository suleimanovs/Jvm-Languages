package oop.interfaceoop.listAnimal;

import oop.interfaceoop.abstractAnimal.Animal;
import oop.interfaceoop.interfaceAnimal.RunAnimal;

/**
 * Created by Osman on 14:44
 */
public class Cat extends Animal implements RunAnimal {
    @Override
    public void eat() {
        System.out.println("Вискас");
    }

    @Override
    public void run(){
        System.out.println("Cat бежит");
    }
}
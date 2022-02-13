package oop.inheriate;

/**
 * Created by Osman on 12:45
 */
public class Cat extends CatFamily {

    public Cat(){
       super(2,4,false);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Eating a mouse");
    }
}

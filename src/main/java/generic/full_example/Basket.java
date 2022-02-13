package generic.full_example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osman on 7:08 PM
 */
public class Basket<F extends Fruit> {

    private final List<F> fruits;

    public Basket(){
        fruits = new ArrayList<>();
    }

    public void add(F fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        float weightOfAll=0;

        for(F fruit: fruits) weightOfAll+=fruit.getWeight();

        return weightOfAll;
    }

    public  int compare(Basket<?> basket){
        return Float.compare(getWeight(), basket.getWeight());
    }

    public static <U extends Fruit> void transfer (Basket<? extends U> src,Basket<? super U> dst){
        dst.fruits.addAll(src.fruits);
        src.fruits.clear();
    }





}

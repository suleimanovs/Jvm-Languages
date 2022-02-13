package anonymclass_interface;

/**
 * Created by Osman on 15:12
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Solution isn't with anonym class, i also created new class [CookableImpl]
         * for interface [Cookable]; Class {CookableImpl} implements interface Cookable
         */
        Director director = new Director();
        Cookable cookable = new CookableImpl();
        director.force(cookable);



        /**Solution is with anonym class */
        Director director2 = new Director();
        director2.force(new Cookable() {
            @Override
            public void cook() {
                System.out.println("I'm cooking!");
            }
        });


        director2.force(() -> System.out.println("I'm cooking!"));

        for(int i =0;i<10;i++){
            System.out.println(i);
        }

    }
}

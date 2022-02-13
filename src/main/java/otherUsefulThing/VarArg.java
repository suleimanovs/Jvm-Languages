package otherUsefulThing;

import static otherUsefulThing.Print.*;

/**
 * Created by Osman on 11:55 AM
 */
public class VarArg {



    static int[] reverse(int... array) {
        System.out.println("Method reverse Started");
        int[] result = new int[array.length];
        int index = array.length - 1;
        for (int i : array) {
            result[index--] = i;
        }
        return result;
    }


    public static void main(String...args) {
        System.out.println("Method Main Started In Static Method");

        int[] varArg = VarArg.reverse(1, 2, 3, 4, 5, 6, 7, 8);//3
        for (int i : varArg) println("varArg style: " + i);//4

        println();//5

        int[] array = VarArg.reverse(new int[]{1, 2, 3, 4, 5, 6, 7, 8});//6
        for (int i : array) println("array style: " + i);//7


        for(String s:args){
            println(s);
        }//8



    }

    static {
        System.out.println("Method Main Started In Static Block");//1
        main("apple","orange","banana","kiwi");//2
        System.out.println("Method Main In Static Block Got His Values");//9


    }
}

package collections.info;

import collections.MyCollection;
import collections.list.MyArrayList;
import collections.model.Car;

/**
 * Created by Osman on 11:01
 */
public class ArrayListExample  {
    public static void main(String[] args) {

     MyCollection carList = new MyArrayList();

        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }

//        for(Car car:carList){
//            System.out.println(car);
//        }
    }
}

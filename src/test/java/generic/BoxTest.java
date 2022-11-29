package generic;

import generics.Box;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Osman on 6:54 PM
 */
public class BoxTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void transfer() {
        ArrayList<Integer> _src = new ArrayList<>();
        ArrayList<Integer> _dst = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            _src.add(i);
            _dst.add(i * 10);
        }
        Box.transfer(_src, _dst);
        assertEquals(0, _src.size());
        assertEquals(20, _dst.size());
    }

    @Test
    public void average() {
        Box<Integer> box = new Box<Integer>(2, 4, 5, 7, 7);
        assertEquals(5, box.average(), 0.001);
    }

    @Test
    public void compare() {
        Box<Integer> box1 = new Box<Integer>(2, 4, 5, 7, 7);
        Box<Float> box2 = new Box<Float>(2.5f, 4.5f, 5f, 7f, 7f);

        assertEquals(-1, box1.compareTo(box2));

    }

    @Test
    public void requireList() {
        /**
         * Integer является наследником Number. И во всех местах где используеться тип Number
         * вместо него мы можем использовать тип Int,Float.
         * Но при этом коллекция List<Number> не является родительем для коллекций List<Integer>
         * По скольку мы явно указали что метод принимает requireList(List<Number> numbers)
         */
        List<Integer> integerList = new ArrayList<Integer>();
        //  Box.requireList(integerList); Error

    }

    @Test
    public void requireListWild() {
        List<Integer> integerList = new ArrayList<Integer>();
        /**
         * По скольку в методе requireListWild(List<? extends Number> numbers)
         * мы указали что коллекция может быть любого типа Number или его наследников.
         */
        Box.requireListWild(integerList);

    }


}
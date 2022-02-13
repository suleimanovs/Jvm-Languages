package collections.queue;

import collections.list.CarLinkedList;
import collections.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Osman on 7:11 PM
 */
public class CarQueueTest {

    CarQueue<Car> carQueue;

    @Before
    public void setUp() throws Exception {
        carQueue = new CarLinkedList<Car>();
        for (int i = 0; i < 10; i++) {
            carQueue.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void add() {

        assertEquals(10, carQueue.size());
    }

    @Test
    public void peek() {

        assertEquals(10,carQueue.size());
        assertEquals("Brand0", carQueue.peek().getBrand());
        assertEquals(10,carQueue.size());
    }

    @Test
    public void pool() {

        assertEquals(10,carQueue.size());
        assertEquals("Brand0", carQueue.pool().getBrand());
        assertEquals(9,carQueue.size());
    }
}
package oop.inheriate.example;

/**
 * Created by Osman on 12:18 PM
 */
public class ColorRect extends Rect{

    ColorRect(int size){
        super(size);
    }

    /**
     * мы не можем переопределять метод [area] родительского класса, не смотря на но то что он
     * абстрактный в суперкаллассе[Figure] родительского класса[Rect],
     * потому что мы его реализовали в родительском классе [Rect],
     * и мы будем использовать именно эту реализацию
     */

}

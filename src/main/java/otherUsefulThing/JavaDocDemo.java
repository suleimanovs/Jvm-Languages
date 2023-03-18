package otherUsefulThing;

/**
 * @author Osman Boy
 * @version 1.0
 * @see JavaDocDemo
 */
public class JavaDocDemo {

    /**
     *{@value PI - это число пи}
     */
    public static final double PI = Math.PI;

    /**
     * {@value }
     * @param integer нечего не делает.
     * @return инкрементит значение
     * @throws Exception не выдаются
     */
   public int foo(int integer){
        System.out.println(integer);
        return integer++;
    }

    /**
     * @return всегда возвращает 0;
     * @deprecated Эту функцию принято считать уставревшим.
     * Вместо этого, используйте: {@link JavaDocDemo#foo(int)}
     * Позже стало принято, что устаревшие программные сущности так же
     * должны быть помечены аннотацией @Deprecated
     */
    @Deprecated
    public int fo(){
        return 0;
    }

    public static void main(String[] arg) {

        JavaDocDemo javaDocDemo = new JavaDocDemo();
    }
}
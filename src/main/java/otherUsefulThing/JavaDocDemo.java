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
     * @throws Exception не выдаються
     */
   public int foo(int integer){
        System.out.println(integer);
        return integer++;
    }

    /**
     * @return всегда возращает 0;
     * @deprecated эту функцию принято считать уставревшим.
     * вместо этого, используйте : {@link JavaDocDemo#foo(int)}
     * Позже стало принято что устаревшие програмные сущности так же
     * должны быть помечены антоацией @Deprecated
     */
    @Deprecated
    public int fo(){
        return 0;
    }

    public static void main(String[] arg) {

        JavaDocDemo javaDocDemo = new JavaDocDemo();
    }
}
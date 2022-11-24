package variables;

/**
 * Vararg - variable arguments
 */
public class Vararg {

    public static void main(String[] args) {
        fromVarargs(1, 2, 3, 4, 5, 6, 7, 8);
        var chars = new int[]{1, 2, 3, 4};
        fromVarargs(chars);
    }

    /**
     * @param args является параметром переменной длины, мы можем передать либо массив, либо переменные через запятую,
     * в списке параметров, varargs должен стоят самым последним. Compilator превращает varargs в обычный массив:
     * <pre>{@code
     * public static void fromVarargs(int[] args) {
     *       for (int i : args) {
     *           System.out.println(i);
     *          }
     *    }
     * }</pre>
     *             <p>
     *             по этому мы не можем объявить такую перегрузку
     */
    public static void fromVarargs(int... args) {
        for (int i : args) {
            System.out.println(i);
        }
    }
}

package variables;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {

        int[] oneDimensionalArray = {1, 2, 3, 4, 5, 6, 7};
        int[][] doubleDimensionalArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][][] thirdDimensionalArray = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {{10, 12, 13}, {14, 15, 16}, {17, 18, 19}}, {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, {{10, 12, 13}, {14, 15, 16}, {17, 18, 19}}};
        int[][][][] fourDimensionalArray = new int[3][][][];
        fourDimensionalArray[0] = thirdDimensionalArray;
        fourDimensionalArray[1] = thirdDimensionalArray;
        fourDimensionalArray[2] = thirdDimensionalArray;

        for (int[][][] i : fourDimensionalArray) { // проходимся по четырех мерному массиву
            for (int[][] j : i) { // проходимся по трех мерному массиву
                for (int[] k : j) { // проходимся по двух мерному массиву
                    for (int element : k) { // проходимся по одно мерному массиву
                        System.out.println(element);
                    }
                }
            }
        }

        /**
         * Allocation step
         * тут мы указали размер массива, вложить в этот массив можно только 12 элементов, в пустых ячейках для
         * примитивных типов будут элементы со значением по default, например для int будет 0.
         * Для ссылочных(reference) типов будет null в качестве значений по default.
         */
        //declaration  allocation
        double[] ids = new double[12];
        //declaration-allocation-initialization
        char[] chars = {'a', 'b', 'c'}; // java сам определит размер по количеству элементов
        char[] chars2 = new char[]{'a', 'b', 'c'}; // java сам определит размер по количеству элементов


        // оба одномерные
        int[] a, b;
        // с одномерный, d двухмерный
        int c[], d[][];
        // f одномерный, g трехмерный
        int[] f, g[][];


        Arrays.asList(chars);
        Arrays.sort(chars);
        Arrays.binarySearch(chars,'g');

    }
}

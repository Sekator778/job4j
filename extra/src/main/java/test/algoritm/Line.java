package test.algoritm;

import java.util.Arrays;

public class Line {
    /**
     * Для получения позиции искомого элемента перебирается набор из N элементов.
     * В худшем сценарии для этого алгоритма искомый элемент оказывается последним в массиве.
     *
     * В этом случае потребуется N итераций для нахождения элемента.
     *
     * Следовательно, временная сложность линейного поиска равна O(N).
     *
     * @param arr - масив для поиска
     * @param elementToSearch - искомый елемент
     * @return - -1 если не нашли все остальное нашли
     */
    public static int linSearch(int[] arr, int elementToSearch) {
        for (int i : arr
        ) {
            if (i == elementToSearch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Временная сложность алгоритма двоичного поиска
     * равна O(log (N)) из-за деления массива пополам.
     * Она превосходит O(N) линейного алгоритма.
     * НО !!! но массив должен быть отсортирован
     *
     * @param arr - масив для поиска
     * @param elementToSearch - искомый елемент
     * @return - -1 если не нашли все остальное нашли
     */

    public static int binarySearch(int[] arr, int elementToSearch) {
        Arrays.sort(arr);
        int firstElement = 0;
        int lastElement = arr.length - 1;
        while (firstElement <= lastElement) {
            int middleIndex = (firstElement + lastElement) / 2;
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (arr[middleIndex] < elementToSearch) {
                firstElement = middleIndex + 1;
            } else if (arr[middleIndex] > elementToSearch) {
                lastElement = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int[] compilePatternArray(String pattern) {
        int patternLength = pattern.length();
        int len = 0;
        int i = 1;
        int[] compilePatternArray = new int[patternLength];
        compilePatternArray[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                compilePatternArray[i] = len;
                i++;
            }
        }
        return null;
    }



    public static void main(String[] args) {
//        System.out.println(linSearch(new int[]{
//                1, 2, 9, 4, 5
//        }, 5));
        System.out.println(binarySearch(new int[]{
                1, 2, 9, 4, 5
        }, 0));
        int middleElement = 1 + (10 - 1) / 2;
        int middleIndex = (1 + 10) / 2;
        System.out.println(middleElement);
        System.out.println(middleIndex);



    }
}

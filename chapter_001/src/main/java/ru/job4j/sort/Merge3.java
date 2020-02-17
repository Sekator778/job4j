//package ru.job4j.sort;
//
//import java.util.Arrays;
//
//public class Merge3 {
//
//    public int[] merge(int[] left, int[] right) {
//        int[] rsl = new int[left.length + right.length];
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while (k < rsl.length) {
//            if ((i > left.length - 1) || left[i] > right[j]) {
//                rsl[k] = right[j];
//                j++;
//            } else if ((j > right.length - 1) || (left[i] < right[j])) {
//                rsl[k] = left[i];
//                i++;
//            }
//            k++;
//        }
//        return rsl;
//    }
//
//    public static void main(String[] args) {
//
//        Merge process = new Merge();
//        int[] rsl = process.merge(
//                new int[] {1, 3, 5},
//                new int[] {2, 4}
//        );
//        System.out.println(Arrays.toString(rsl));
//
//    }
//}

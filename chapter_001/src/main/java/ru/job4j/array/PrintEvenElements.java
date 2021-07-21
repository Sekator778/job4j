package ru.job4j.array;

public class PrintEvenElements {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i = 0; i < numbers.length; i++) {
            if (ifEven(i)) {
                System.out.println(
                        "Текущий элемент массива начиная с последнего: "
                                + numbers[numbers.length - 1 - i]
                );
            }
        }
    }

    /**
     * проверка что число четное
     */
    private static boolean ifEven(int num) {
        return num % 2 == 0;
    }
}
package test.dop;

import java.util.*;
import java.util.stream.Collectors;

/**
 * задача
 * на вход получаем 2 строки
 * определить или они(строки) состоят из тех же символов
 * регистр букв оставлен для боьшей сложности
 * <p>
 * в тесте добавляем букву А для отличия строки
 */
public class StringTwo {

    /**
     * линейный поиск сложность
     *
     * @param s1 - pattern строка по которой сравниваем
     * @param s2 - строка которую сравниваем
     */
    static void indentinity(String s1, String s2) {
        char[] pattern = s1.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char ch : pattern
        ) {
            list.add(ch);
        }
        int rsl = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (!list.contains(s2.charAt(i))) {
//                System.out.println("no");
                rsl = -1;
                break;
            }
        }
        if (rsl == 0) {
            System.out.println("yes");
        }
    }

    /**
     * Алгоритм
     * сначало две строки в Set там остаються только одиночки
     * символы которые встречаються только 1н раз
     * таким образом мы уменьшаем супер длинную строку до минимума
     * <p>
     * через один форич сравниваем один сет на наличие в нем символов из другого
     *
     * @param s1 строка
     * @param s2 строка
     */
    static void indentinity2(String s1, String s2) {
        int rsl = 0;
        Set<Character> pattern = s1.chars()
                .mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        Set<Character> set = s2.chars()
                .mapToObj(ch1 -> (char) ch1).collect(Collectors.toSet());

        for (Character ch : set
        ) {
            if (!pattern.contains(ch)) {
//                System.out.print("no");
                rsl = -1;
                break;
            }
        }
        if (rsl == 0) {
            System.out.println("yes");
        }
    }

    /**
     * Генератор строки заданной длинны
     *
     * @param count - количество символов в строке(длина)
     * @return - строка рандомная состоит из алфавита
     */
    private static String getRandom(int count) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        String alphabet = "BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] allAlphabet = alphabet.toCharArray();
        int len = alphabet.length();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(allAlphabet[random.nextInt(len)]);
        }
        return stringBuilder.toString();
    }

    /**
     * Таймер времени исполнения указаного алгоритма
     *
     * @param s1     - тестовые строки
     * @param s2     - тестовые строки
     * @param number - номер алгоритма на выполнение
     */
    public static void timer(String s1, String s2, int number) {
        double after = System.currentTimeMillis();
        switch (number) {
            case 1:
                indentinity(s1, s2);
                break;
            case 2:
                indentinity2(s1, s2);
                break;
            default:
                System.out.println("error number");
        }
        System.out.printf("Time algorithm # %s - %s mS \n", number, (System.currentTimeMillis() - after));


    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < 1; i++) {
            s1 = (getRandom(100_000_000));
        }
        s2 = s1;
        s2 = s2 + "A";
        timer(s1, s2, 1);
        timer(s1, s2, 2);
        timer("mama", "volvo", 1);
        timer("mama", "volvo", 2);
    }
}

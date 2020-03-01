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
public class StringCharCompare {

    /**
     * линейный поиск сложность
     *
     * @param s1 - pattern строка по которой сравниваем
     * @param s2 - строка которую сравниваем
     */
    public static boolean indentinity(String s1, String s2) {
        boolean rsl = true;
        char[] pattern = s1.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char ch : pattern
        ) {
            list.add(ch);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!list.contains(s2.charAt(i))) {
                rsl = false;
                break;
            }
        }
        return rsl;
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
    public static boolean indentinity2(String s1, String s2) {
        boolean rsl = true;
        Set<Character> pattern = s1.chars()
                .mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        Set<Character> set = s2.chars()
                .mapToObj(ch1 -> (char) ch1).collect(Collectors.toSet());

        for (Character ch : set
        ) {
            if (!pattern.contains(ch)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    /**
     * добавляем в множество
     * чекаем сайз
     * добавляем снова в множество
     * если сайз изменился значит есть другие
     *
     * @param s1 строка
     * @param s2 строка
     */
    public static boolean indentinity3(String s1, String s2) {
        boolean rsl = false;
        Set<Character> set = s1.chars()
                .mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        int size = set.size();
        set.addAll(s2.chars()
                .mapToObj(ch -> (char) ch).collect(Collectors.toSet()));
        if (size == set.size()) {
            rsl = true;
        }
        return rsl;
    }

    /**
     * тут ньюанс что первая должна быть короче 2й
     * тогда по разности длин также узнем есть ли еще
     * какието символы в2й строке кроме символов 1й строки
     * <p>
     * тут делаем тоже что и с листом
     * но наблюдаем преимущество хешмапы
     * как она шустро по ключам работает
     *
     * @param s1 строка
     * @param s2 строка
     */
    public static boolean indentinity4(String s1, String s2) {
        boolean rsl = false;
        int x = 1;
        char[] one = s1.toCharArray();
        char[] two = s2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : one
        ) {
            map.put(ch, x);
        }
        int size = map.size();
        for (Character ch : two
        ) {
            map.putIfAbsent(ch, x); // просто put тот же результат
        }
        if (size == map.size()) {
            rsl = true;
        }
        return rsl;
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
    public static boolean timer(String s1, String s2, int number) {
        boolean rsl = false;
        double after = System.currentTimeMillis();
        switch (number) {
            case 1:
                rsl = indentinity(s1, s2);
                break;
            case 2:
                rsl = indentinity2(s1, s2);
                break;
            case 3:
                rsl = indentinity3(s1, s2);
                break;
            case 4:
                rsl = indentinity4(s1, s2);
                break;
            default:
                System.out.println("error number");
        }
        System.out.printf("Time algorithm # %s - %s mS \n", number, (System.currentTimeMillis() - after));
        return rsl;
    }

    /**
     * 1й раз максимум елемнтов в строку
     * 2й раз минимальное слово
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < 1; i++) {
            s1 = (getRandom(100_000_000));
        }
        s2 = s1;
//        s2 = s2 + "A";
        System.out.println(timer(s1, s2, 1));
        System.out.println(timer(s1, s2, 2));
        System.out.println(timer(s1, s2, 3));
        System.out.println(timer(s1, s2, 4));
        System.out.println(timer("mama", "mamaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 1));
        System.out.println(timer("mama", "mamaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 2));
        System.out.println(timer("mama", "mamaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 3));
        System.out.println(timer("mama", "mamaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 4));
    }
}

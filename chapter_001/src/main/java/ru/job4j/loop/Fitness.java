package ru.job4j.loop;
//1. Вы должны, использовать цикл while. В условие цикла нужно сравнивать тягу Ивана и Николая,
// если тяга Ивана больше нужно выйти из цикла.
//2. В теле цикла делать умножение тяги ivan *= 3. - Это запись равносильна записи ivan = ivan * 3;
public class Fitness {
    public static int calc(int ivan, int nik) {
        int month = 0;
        while (ivan <= nik){
            ivan *=3;
            nik *=2;
            month ++;
        }
        return month;
    }
}
package ru;
//   public int year(, int salary, double percent) {
//        int year = 0;
//        do {
//            amount = (int) (amount + (amount / 100 * percent));
//            amount = amount - salary;
//            year++;
//        } while (amount > 0);
//        return year;
//    }
public class Test {
    public static void main(String[] args) {
        int year = 0;
        int salary = 100;
        int amount = 100;
        double percent = 50;
        double narah = salary / 100 * percent;
        do {
            amount = (int) (amount + (amount / 100 * percent));
            amount = amount - salary;
            year++;
        } while (amount > 0);
        System.out.println(year);


    }



}

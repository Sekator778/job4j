package ru.job4j.pojo;

public class Student {
    private String fio;
    private int group;
    private String date;

    public String getFio() {
        return fio;
    }

    public int getGroup() {
        return group;
    }

    public String getDate() {
        return date;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setDate("21.02.2000");
        student.setFio("Gogol Dima");
        student.setGroup(47);
        System.out.println(student.getFio());
        System.out.println(student.getDate());
        System.out.println(student.getGroup());
    }
}

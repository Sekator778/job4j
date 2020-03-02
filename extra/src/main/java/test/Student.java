package test;

public class Student implements Comparable<Student> {
    private int score;
    private String surname;

    public int getScore() {
        return score;
    }

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    @Override
    public String toString() {
        return surname + " : " + score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }

}

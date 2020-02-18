package ru.job4j.condition;

import static java.lang.Math.pow;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return Math.sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }

    public double distance3d(Point that) {
        return Math.sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2) + pow(this.z - that.z, 2));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }

    public void info3d() {
        System.out.println(String.format("Point[%s, %s, %s]", this.x, this.y, this.z));
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 0);
        Point p3 = new Point(0, 0, 1);
        Point p4 = new Point(0, 0, 5);
        double result = p1.distance(p2);
        p4.info3d();
        System.out.println("distance from (0, 0) to (2, 0) = " + result);
        System.out.println(String.format("Distance 3d from point %s, %s, %s to point %s, %s ,%s = %s",
                p3.x, p3.y, p3.z, p4.x, p4.y, p4.z, p3.distance3d(p4)));
    }
}
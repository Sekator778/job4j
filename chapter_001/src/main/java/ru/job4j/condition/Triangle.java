package ru.job4j.condition;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point a, Point b, Point c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public double perimetr() {
        double result = 0;
        if (!exist(first, second, third)) {
            System.out.println("Triangle no exist");
        } else {
            double ab = this.first.distance(this.second);
            double ad = this.first.distance(this.third);
            double bc = this.second.distance(this.third);
            result = (ab + ad + bc) / 2;
        }
        return result;
    }

    public double area() {
        double result = 0;
        if (!exist(first, second, third)) {
            System.out.println("Triangle no exist");
        } else {
            double perimetr = this.perimetr();
            double ab = first.distance(second);
            double ad = first.distance(third);
            double bc = second.distance(third);
            result = Math.sqrt(perimetr * (perimetr - ab) * (perimetr - ad) * (perimetr - bc));
        }
        return result;
    }

    public static boolean exist(Point first, Point second, Point third) {
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        return ((ab + ac) > bc && (ac + bc) > ab && (ab + bc) > ac);
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 0);
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.println(triangle.perimetr());
        System.out.println(triangle.area());
    }
}
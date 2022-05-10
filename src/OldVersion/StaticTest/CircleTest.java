package Learn.StaticTest;

public class CircleTest {

}

class Circle {
    private double radius;
    private int id;

    private static int total = 0;
    private static int init = 1001;

    public Circle() {
        id = init++;
        total++;
    }
    public Circle(double radius) {
        this.radius = radius;
        id = init++;
        total++;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

    public double findArea() {
        return 3.14 * radius * radius;
    }
}
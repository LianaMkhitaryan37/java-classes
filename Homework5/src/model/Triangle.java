package model;

public class Triangle extends Shape {
    private int a = 3, b = 4, c = 5;

    public Triangle(int[] corners) {
        setCorners(corners);
    }

    public int[] getCorners() {
        return new int[]{a, b, c};
    }

    public void setCorners(int[] corners) {
        if (corners.length < 3 || corners[0] <= 0 || corners[1] <= 0 || corners[2] <= 0) {
            System.out.println("Invalid data");
            return;
        }
        int maxCorner = Math.max(corners[0], Math.max(corners[1], corners[2]));
        if (corners[0] + corners[1] <= maxCorner || corners[2] + corners[1] <= maxCorner || corners[0] + corners[2] <= maxCorner) {
            System.out.println("Invalid data");
            return;
        }
        a = corners[0];
        b = corners[1];
        c = corners[2];
    }

    @Override
    public double area() {
        double s = perimeter() / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }


    @Override
    public void draw() {
        System.out.println("Draw Triangle");
        System.out.println("Corners are [ " + a + " , " + b + " , " + c + " ]");
    }
}

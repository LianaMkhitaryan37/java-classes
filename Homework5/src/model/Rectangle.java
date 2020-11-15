package model;

import java.awt.Point;

public class Rectangle extends Shape {
    private Point topLeft;
    private int width = 1;
    private int height = 1;

    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        setWidth(width);
        setHeight(height);
    }

    public Rectangle() {
        super();
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            System.out.println("Width must be positive");
            return;
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            System.out.println("Height must be positive");
            return;
        }
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle Draw");
        System.out.println(
                "{ Start=" + "[x=" + topLeft.x + ",y=" + topLeft.y + "]" +
                        ", width=" + width +
                        ", height=" + height +
                        '}'
        );
    }

    double diagonalLength() {
        return Math.sqrt(width * width + height * height);
    }
}

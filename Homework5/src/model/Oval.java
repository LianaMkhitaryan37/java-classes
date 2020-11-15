package model;

import java.awt.*;

public class Oval extends Shape {
    private int radiusHorizontal = 1, radiusVertical = 1;
    protected Point center;

    public Oval(int radiusHorizontal, int radiusVertical, Point center) {
        setRadiusHorizontal(radiusHorizontal);
        setRadiusVertical(radiusVertical);
        this.center = center;
    }

    public Oval() {
    }

    public int getRadiusHorizontal() {
        return radiusHorizontal;
    }

    public void setRadiusHorizontal(int radiusHorizontal) {
        if (radiusHorizontal <= 0) {
            System.out.println("Horizontal radius can't be negative");
            return;
        }
        this.radiusHorizontal = radiusHorizontal;
    }

    public int getRadiusVertical() {
        return radiusVertical;
    }

    public void setRadiusVertical(int radiusVertical) {
        if (radiusVertical <= 0) {
            System.out.println("Vertical radius can't be negative");
            return;
        }
        this.radiusVertical = radiusVertical;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public double area() {
        return Math.PI * radiusHorizontal * radiusVertical;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * Math.sqrt((radiusHorizontal * radiusHorizontal + radiusVertical * radiusVertical) / 2.0);
    }

    @Override
    public void draw() {
        System.out.println("Oval Draw");
        System.out.println("{" +
                "radiusHorizontal=" + radiusHorizontal +
                ", radiusVertical=" + radiusVertical +
                ", center=" + center +
                '}');
    }
}

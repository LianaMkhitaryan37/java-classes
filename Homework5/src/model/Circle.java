package model;

import java.awt.*;

public class Circle extends Oval {

    public Circle(Point center, int radius) {
        super(radius, radius, center);
        if (radius <= 0) {
            System.out.println("Radius must be positive");
        }
    }

    public int getRadius() {
        assert getRadiusVertical() == getRadiusHorizontal();
        return getRadiusVertical();
    }

    @Override
    public double area() {
        int radius = getRadius();
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public void setRadiusHorizontal(int radius) {
        if (radius <= 0) {
            return;
        }
        super.setRadiusHorizontal(radius);
        super.setRadiusVertical(radius);
    }

    @Override
    public void setRadiusVertical(int radiusVertical) {
        setRadiusHorizontal(radiusVertical);
    }

    @Override
    public void draw() {
        System.out.println("Circle draw");
        System.out.println("{" +
                "radius=" + getRadiusVertical() +
                ", center=" + center +
                '}');
    }
}

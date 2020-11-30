package model.shapes;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Circle extends Oval {

    public Circle() {
        super();
    }

    public Circle(Point center, int radius) {
        super(radius, radius, center);
        if (radius <= 0) {
            System.out.println("Radius must be positive");
        }
    }

    private Circle(String contentOfFile) {
        String[] values = contentOfFile.split(",");
        setCenter(new Point(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1])
        ));
        setRadiusHorizontal(Integer.parseInt(values[2]));
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

    @Override
    public Shape readFromFile(String filePath) {
        try {
            String contentOfFile = Files.readAllLines(Paths.get(filePath)).toArray(new String[0])[0];
            return new Circle(contentOfFile);
        } catch (IOException e) {
            System.out.printf("%s file doesn't exist\n", filePath);
        }
        return new Circle();
    }

    @Override
    public void writeToFile(String filePath) {
        String result = String.format("%d,%d,%d", center.x, center.y, getRadius());
        try {
            Files.write(Paths.get(filePath), result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

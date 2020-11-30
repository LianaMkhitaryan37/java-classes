package model.shapes;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Oval implements SaveAbleShape {
    private int radiusHorizontal = 1, radiusVertical = 1;
    protected Point center;

    public Oval(int radiusHorizontal, int radiusVertical, Point center) {
        setRadiusHorizontal(radiusHorizontal);
        setRadiusVertical(radiusVertical);
        this.center = center;
    }

    public Oval() {
    }

    private Oval(String contentOfFile) {
        String[] values = contentOfFile.split(",");
        setCenter(new Point(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1])
        ));
        setRadiusHorizontal(Integer.parseInt(values[2]));
        setRadiusVertical(Integer.parseInt(values[3]));
    }

    public int getRadiusHorizontal() {
        return radiusHorizontal;
    }

    public void setRadiusHorizontal(int radiusHorizontal) {
        if (radiusHorizontal <= 0) {
            throw new RuntimeException("Horizontal radius can't be negative");
        }
        this.radiusHorizontal = radiusHorizontal;
    }

    public int getRadiusVertical() {
        return radiusVertical;
    }

    public void setRadiusVertical(int radiusVertical) {
        if (radiusVertical <= 0) {
            throw new RuntimeException("Vertical radius can't be negative");
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

    @Override
    public boolean intersects(Shape other) {
        return other.intersects(this);
    }

    @Override
    public boolean intersects(Rectangle other) {
        return other.getTopLeft() == center;
    }

    @Override
    public boolean intersects(Triangle other) {
        return other.intersects(this);
    }

    public boolean intersects(Oval other) {
        int distanceX = Math.abs(other.center.x - center.x);
        int distanceY = Math.abs(other.center.y - center.y);
        return distanceX < (other.radiusHorizontal + radiusHorizontal) || distanceY < (other.radiusVertical + radiusVertical);
    }

    @Override
    public Shape readFromFile(String filePath) {
        try {
            String contentOfFile = Files.readAllLines(Paths.get(filePath)).toArray(new String[0])[0];
            return new Oval(contentOfFile);
        } catch (IOException e) {
            System.out.printf("%s file doesn't exist\n", filePath);
        }
        return new Oval();
    }

    @Override
    public void writeToFile(String filePath) {
        String result = String.format("%d,%d,%d,%d", center.x, center.y, radiusHorizontal, radiusVertical);
        try {
            Files.write(Paths.get(filePath), result.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

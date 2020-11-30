package model.shapes;

public interface Shape {
    double area();

    double perimeter();

    void draw();

    boolean intersects(Shape other);
    boolean intersects(Rectangle other);
    boolean intersects(Triangle other);
    boolean intersects(Oval other);
}

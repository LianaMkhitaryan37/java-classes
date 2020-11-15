package model;

import java.awt.Point;

public class Square extends Rectangle {
    public Square(Point topLeft, int corner) {
        super(topLeft, corner, corner);
    }

    @Override
    public void setWidth(int corner) {
        if (corner < 0) {
            System.out.println("Corner must be positive");
            return;
        }
        super.setWidth(corner);
        super.setHeight(corner);
    }

    @Override
    public void setHeight(int corner) {
        setWidth(corner);
    }

    @Override
    public void draw() {
        System.out.println("Square Draw");
        System.out.println(
                "{ Start=" + "[x=" + getTopLeft().x + ",y=" + getTopLeft().y + "]" +
                        ", corner=" + getHeight() + '}'
        );
    }
}

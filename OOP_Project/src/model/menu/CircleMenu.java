package model.menu;

import model.shapes.Circle;
import service.CircleService;
import service.OvalService;
import service.ShapeService;

public class CircleMenu extends ShapeMenu {

    Circle shape;

    public CircleMenu(Circle shape) {
        super(shape);
        this.shape = shape;
    }

    @Override
    public int createSpecializedMenu() {
        System.out.println("5: Write To File");
        System.out.println("6: Get Radius");
        System.out.println("7: Set Radius");
        System.out.println("8: Get Center Coordinates");
        System.out.println("9: Set Center Coordinates");
        return 5;
    }

    @Override
    public Menu processRequest(int n) {
        switch (n) {
            case 5:
                ShapeService.writeToFile(shape);
                break;
            case 6:
                System.out.println(shape.getRadius());
                break;
            case 7:
                CircleService.changeRadius(shape);
                break;
            case 8:
                System.out.println(shape.getCenter());
                break;
            case 9:
                OvalService.changeCenter(shape);
                break;
            default:
                return super.processRequest(n);
        }
        return null;
    }
}

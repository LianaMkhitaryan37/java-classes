package model.menu;

import model.shapes.Oval;
import service.OvalService;
import service.ShapeService;

public class OvalMenu extends ShapeMenu {
    private final Oval shape;

    public OvalMenu(Oval shape) {
        super(shape);
        this.shape = shape;
    }

    @Override
    public int createSpecializedMenu() {
        System.out.println("5: Write To File");
        System.out.println("6: Get Horizontal Radius");
        System.out.println("7: Get Horizontal Radius");
        System.out.println("8: Get Vertical Radius");
        System.out.println("9: Set Vertical Radius");
        System.out.println("10: Get Center Coordinates");
        System.out.println("11: Set Center Coordinates");
        return 7;
    }

    @Override
    public Menu processRequest(int n) {
        switch (n) {
            case 5:
                ShapeService.writeToFile(shape);
                break;
            case 6:
                System.out.println(shape.getRadiusHorizontal());
                break;
            case 7:
                OvalService.changeHorizontalRadius(shape);
                break;
            case 8:
                System.out.println(shape.getRadiusVertical());
                break;
            case 9:
                OvalService.changeVerticalRadius(shape);
                break;
            case 10:
                System.out.println(shape.getCenter());
                break;
            case 11:
                OvalService.changeCenter(shape);
                break;
            default:
                return super.processRequest(n);
        }
        return this;
    }
}

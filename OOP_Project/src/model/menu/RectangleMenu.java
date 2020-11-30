package model.menu;

import model.shapes.Rectangle;
import service.RectangleService;
import service.ShapeService;

public class RectangleMenu extends ShapeMenu {
    private Rectangle shape;

    public RectangleMenu(Rectangle shape) {
        super(shape);
        this.shape = shape;
    }

    @Override
    public int createSpecializedMenu() {
        System.out.println("5: Write To File");
        System.out.println("6: Get Top Left Coordinate");
        System.out.println("7: Set Top Left Coordinate");
        System.out.println("8: Get Width");
        System.out.println("9: Set Width");
        System.out.println("10: Get Height");
        System.out.println("11: Set Height");
        System.out.println("12: Get Diagonal Length");
        return 8;
    }

    @Override
    public Menu processRequest(int n) {
        switch (n) {
            case 5:
                ShapeService.writeToFile(shape);
                break;
            case 6:
                System.out.println(shape.getTopLeft());
                break;
            case 7:
                RectangleService.changeTopLeft(shape);
                break;
            case 8:
                System.out.println(shape.getWidth());
                break;
            case 9:
                RectangleService.changeWidth(shape);
                break;
            case 10:
                System.out.println(shape.getHeight());
                break;
            case 11:
                RectangleService.changeHeight(shape);
                break;
            case 12:
                System.out.println(shape.diagonalLength());
                break;
            default:
                return super.processRequest(n);
        }
        return this;
    }
}

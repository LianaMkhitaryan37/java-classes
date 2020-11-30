package model.menu;

import model.shapes.Triangle;
import service.TriangleService;
import service.ShapeService;

import java.util.Arrays;

public class TriangleMenu extends ShapeMenu {
    private final Triangle shape;

    public TriangleMenu(Triangle shape) {
        super(shape);
        this.shape = shape;
    }

    @Override
    public int createSpecializedMenu() {
        System.out.println("5: Write To File");
        System.out.println("6: Get Start Coordinate");
        System.out.println("7: Set Start Coordinate");
        System.out.println("8: Get Corners");
        System.out.println("9: Set Corners");
        return 5;
    }

    @Override
    public Menu processRequest(int n) {
        switch (n) {
            case 5:
                ShapeService.writeToFile(shape);
                break;
            case 6:
                System.out.println(shape.getStart());
                break;
            case 7:
                TriangleService.changeStart(shape);
                break;
            case 8:
                System.out.println(Arrays.toString(shape.getCorners()));
                break;
            case 9:
                TriangleService.changeCorners(shape);
                break;
            default:
                return super.processRequest(n);
        }
        return this;
    }
}

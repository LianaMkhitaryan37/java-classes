package model.menu;

import model.shapes.Square;
import service.RectangleService;
import service.ShapeService;
import service.SquareService;

public class SquareMenu extends ShapeMenu{
    private final Square square;

    public SquareMenu(Square square) {
        super(square);
        this.square = square;
    }

    @Override
    public int createSpecializedMenu() {
        System.out.println("5: Write To File");
        System.out.println("6: Get Top Left Coordinate");
        System.out.println("7: Set Top Left Coordinate");
        System.out.println("8: Get corner");
        System.out.println("9: Set corner");
        System.out.println("10: Get Diagonal Length");
        return 6;
    }

    @Override
    public Menu processRequest(int n) {
        switch (n) {
            case 5:
                ShapeService.writeToFile(square);
                break;
            case 6:
                System.out.println(square.getTopLeft());
                break;
            case 7:
                RectangleService.changeTopLeft(square);
                break;
            case 8:
                System.out.println(square.getWidth());
                break;
            case 9:
                SquareService.changeCorner(square);
                break;
            case 10:
                System.out.println(square.diagonalLength());
                break;
            default:
                return super.processRequest(n);
        }
        return this;
    }
}

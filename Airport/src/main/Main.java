package main;

import models.Plane;
import services.PlaneService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PlaneService service = new PlaneService();
        Plane[] planes = service.createPlanes();
        System.out.println("Task 1");
        service.printPlaneInfo(planes[0]);
        service.customPrintPlane(planes[0]);
        service.printPlaneInfo(service.newestPlane(planes[0],planes[1]));
        System.out.println(service.getModelOfBiggestWingSpan(planes[0],planes[1]));
        service.printPlaneInfo(service.getHighestCostPlane(planes[0],planes[1],planes[2]));
        service.printCountryOfMinSeatCountPlane(planes[0],planes[1],planes[2]);
        service.printNotMilitaryPlanes(planes);
        service.printMilitaryPlanesWithMoreThen100Hours(planes);
        service.printPlaneInfo(service.getPlaneWithMinimalWeight(planes));
        service.printPlanesByAscendingYear(planes);
        service.printPlanesByDescendingNumberOfSeats(planes);
        service.printPlaneInfo(service.getMilitaryPlaneWithMinimalCost(planes));
    }
}

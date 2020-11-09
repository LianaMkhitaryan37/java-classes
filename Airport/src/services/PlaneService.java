package services;

import models.Plane;

import java.util.Scanner;

public class PlaneService {
    public void printPlaneInfo(Plane plane) {
        System.out.println(
                "Plane{" +
                        "model='" + plane.getModel() + '\'' +
                        ", country='" + plane.getCountry() + '\'' +
                        ", year=" + plane.getYear() +
                        ", hours=" + plane.getHours() +
                        ", military=" + plane.isMilitary() +
                        ", engineType='" + plane.getEngineType() + '\'' +
                        ", weight=" + plane.getWeight() +
                        ", wingSpan=" + plane.getWingSpan() +
                        ", topSpeed=" + plane.getTopSpeed() +
                        ", seats=" + plane.getSeats() +
                        ", cost=" + plane.getCost() +
                        '}'
        );
    }

    public void customPrintPlane(Plane plane) {
        if (plane.isMilitary()) {
            System.out.println("Plane cost=" + plane.getCost() + " top speed = " + plane.getTopSpeed());
        } else {
            System.out.println("Plane model=" + plane.getModel() + " top speed = " + plane.getCountry());
        }
    }

    public Plane newestPlane(Plane obj1, Plane obj2) {
        return (obj1.getYear() >= obj2.getYear()) ? obj1 : obj2;
    }

    public String getModelOfBiggestWingSpan(Plane obj1, Plane obj2) {
        return obj1.getWingSpan() > obj2.getWingSpan() ? obj1.getModel() : obj1.getModel();
    }

    public Plane getHighestCostPlane(Plane obj1, Plane obj2, Plane obj3) {
        Plane result = obj1;
        if (obj2.getCost() > result.getCost()) {
            result = obj2;
        }
        if (obj3.getCost() > result.getCost()) {
            result = obj3;
        }
        return result;
    }

    public void printCountryOfMinSeatCountPlane(Plane obj1, Plane obj2, Plane obj3) {
        Plane result = obj1;
        if (obj2.getSeats() < result.getSeats()) {
            result = obj2;
        }
        if (obj3.getSeats() < result.getSeats()) {
            result = obj3;
        }
        System.out.println("Country of the plane with smallest seats count" + result.getCountry());
    }

    public void printNotMilitaryPlanes(Plane[] array) {
        for (Plane element : array) {
            if (!element.isMilitary())
                printPlaneInfo(element);
        }
    }

    public void printMilitaryPlanesWithMoreThen100Hours(Plane[] array) {
        for (Plane element : array) {
            if (element.isMilitary() && element.getHours() > 100) {
                printPlaneInfo(element);
            }
        }
    }

    public Plane getPlaneWithMinimalWeight(Plane[] array) {
        int index = 0;
        for (int i = 1; i < array.length; ++i) {
            if (array[i].getWeight() <= array[index].getWeight())
                index = i;
        }
        return array[index];
    }

    public Plane getMilitaryPlaneWithMinimalCost(Plane[] array) {
        Plane result = null;
        double minCost = Double.MIN_VALUE;
        for (Plane plane : array) {
            if (plane.isMilitary() && plane.getCost() < minCost) {
                minCost = plane.getCost();
                result = plane;
            }
        }
        return result;
    }

    public void printPlanesByAscendingYear(Plane[] array) {
        int numberOfElementsToCompare = array.length;
        while (numberOfElementsToCompare != 0) {
            int indexOfLastSwappedElement = 0;
            for (int i = 1; i < numberOfElementsToCompare; ++i) {
                if (array[i - 1].getYear() > array[i].getYear()) {
                    Plane z = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = z;
                    indexOfLastSwappedElement = i;
                }
            }
            numberOfElementsToCompare = indexOfLastSwappedElement;
        }
        for (Plane element :
                array) {
            printPlaneInfo(element);
        }
    }

    public void printPlanesByDescendingNumberOfSeats(Plane[] array) {
        int numberOfElementsToCompare = array.length;
        while (numberOfElementsToCompare != 0) {
            int indexOfLastSwappedElement = 0;
            for (int i = 1; i < numberOfElementsToCompare; ++i) {
                if (array[i - 1].getSeats() < array[i].getSeats()) {
                    Plane z = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = z;
                    indexOfLastSwappedElement = i;
                }
            }
            numberOfElementsToCompare = indexOfLastSwappedElement;
        }
        for (Plane element :
                array) {
            printPlaneInfo(element);
        }
    }

    private final Scanner myObj = new Scanner(System.in);

    public Plane createPlane() {
        Plane result = new Plane();

        System.out.println("Enter model");
        result.setModel(myObj.next());

        System.out.println("Enter country");
        result.setCountry(myObj.next());
        System.out.println("Enter year");
        result.setYear(myObj.nextInt());

        System.out.println("Enter hours");
        result.setHours(myObj.nextInt());

        System.out.println("Enter military");
        result.setMilitary(myObj.nextBoolean());

        System.out.println("Enter engineType");
        result.setEngineType(myObj.next());
        System.out.println("Enter Weigh");
        result.setWeight(myObj.nextInt());
        System.out.println("Enter WingSpan");
        result.setWingSpan(myObj.nextByte());
        System.out.println("Enter topSpeed");
        result.setTopSpeed(myObj.nextInt());

        System.out.println("Enter seats");
        result.setSeats(myObj.nextInt());
        System.out.println("Enter Cost");
        result.setCost(myObj.nextDouble());

        return result;
    }

    public Plane[] createPlanes() {
        System.out.println("Number of planes");
        int n = myObj.nextInt();
        Plane[] arr = new Plane[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("Create Plane" + i);
            arr[i] = createPlane();
        }
        return arr;
    }

}

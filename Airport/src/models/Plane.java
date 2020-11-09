package models;

public class Plane {
    private String model = "Delta";
    private String country = "Armenia";
    private int year = 1903;
    private int hours = 0;
    private boolean military;
    private String engineType = "Rolls-Royce Trent 900";
    private int weight = 1000;
    private byte wingSpan = 10;
    private int topSpeed = 1000;
    private int seats = 0;
    private double cost = 445.6;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model.isEmpty()) {
            System.out.println("Please Enter not empty model name , Current model name is " + this.model);
            return;
        }
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.isEmpty()) {
            System.out.println("Please Enter not empty country name , Current country name is " + this.country);
            return;
        }
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1903 || year > 2020) {
            System.out.println("Please Enter valid year (in range [1903,2020]) , Current year value is " + this.year);
            return;
        }
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours < 0 || hours > 10000) {
            System.out.println("Please Enter valid hour (in range [0,10000]) , Current hour value is " + this.hours);
            return;
        }
        this.hours = hours;
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        if (engineType.isEmpty()) {
            System.out.println("Please Enter not empty engine type, Current value is " + this.engineType);
            return;
        }
        this.engineType = engineType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 1000 || weight > 160000) {
            System.out.println("Please Enter valid weight (in range [1000,160000]) , Current value is " + this.weight);
            return;
        }
        this.weight = weight;
    }

    public byte getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(byte wingspan) {
        if (wingspan < 10 || wingspan > 45) {
            System.out.println("Please Enter valid wingspan (in range [0,45]) , Current value is " + this.wingSpan);
            return;
        }
        this.wingSpan = wingspan;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        if (topSpeed < 0) {
            System.out.println("Please enter non negative top speed, Current value is " + this.topSpeed);
            return;
        }
        this.topSpeed = topSpeed;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats < 0) {
            System.out.println("Please enter non negative seats, Current value is " + this.seats);
            return;
        }
        this.seats = seats;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (seats < 0) {
            System.out.println("Please enter non negative cost, Current value is " + this.seats);
            return;
        }
        this.cost = cost;
    }
}

package com.company.info;

public class Date {
    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        if (day > (byte) 0 && day < (byte)32)
            this.day = day;
        else
            System.out.println("Invalid day value" + day);
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        if (month > (byte) 0 && month < (byte)13)
            this.month = month;
        else
            System.out.println("Invalid month value" + day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>1900 && year<2020)
            this.year = year;
    }

    byte day, month;
    int year = 1999;

    public Date(byte day, byte month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
}

package model;

public class StudentCompare {
    static boolean compareWithMarks = true;
    public static void setToCompareWithYear(){
        compareWithMarks=false;
    }
    public static boolean compare(Student first, Student second) {
        if (compareWithMarks) {
            return first.getMark() > second.getMark();
        } else {
            return first.getYear() > second.getYear();
        }
    }
}
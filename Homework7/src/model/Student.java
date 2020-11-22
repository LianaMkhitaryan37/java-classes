package model;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private char gender;
    private double mark;

    private Student(String firstName, String lastName, int year, char gender, double mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.gender = gender;
        this.mark = mark;
    }

    static Student parseStudent(String from) {
        String[] values = from.split(",");
        validateString(values);
        return new Student(values[0],
                values[1],
                Integer.parseUnsignedInt(values[2]),
                values[3].charAt(0),
                Double.parseDouble(values[4]));
    }

    static void validateString(String[] parts) {
        assert (parts.length == 4);
        assert (!parts[0].isEmpty());
        assert (!parts[1].isEmpty());
        assert (!parts[2].isEmpty());
        assert (parts[3].length() == 1);
        assert (!parts[4].isEmpty());
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", gender=" + gender +
                ", mark=" + mark +
                '}';
    }

    public boolean isMale() {
        return gender == 'm';
    }

    public boolean isFemale() {
        return gender == 'f';
    }

    public double getMark() {
        return mark;
    }

    public int getYear() {
        return year;
    }
}

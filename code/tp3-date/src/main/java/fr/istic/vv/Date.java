package fr.istic.vv;


public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;


    // Constructor to initialize the date with day, month, and year
    // It throws an exception if the date is not valid
    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }


    // Static method to check if a given date is valid
    public static boolean isValidDate(int day, int month, int year) {
        // Year should be positive, month should be between 1 and 12
        if (year < 1 || month < 1 || month > 12) return false;


        // Array holding the number of days in each month
        // Adjust February based on whether it's a leap year
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Return true if day is within the valid range for the given month
        return day >= 1 && day <= daysInMonth[month - 1];
    }


    // Static method to determine if a year is a leap year
    public static boolean isLeapYear(int year) {
        // Leap year if divisible by 4 but not by 100, or divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    // Method to get the next date
    public Date nextDate() {
        // Array holding the number of days in each month, adjusting February for leap years
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int newDay = day + 1;
        int newMonth = month;
        int newYear = year;


        // If the new day exceeds the days in the current month, move to the next month
        if (newDay > daysInMonth[month - 1]) {
            newDay = 1;
            newMonth++;
            // If the new month exceeds December, move to the next year
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }
        return new Date(newDay, newMonth, newYear);
    }


    // Method to get the previous date
    public Date previousDate() {
        // Array holding the number of days in each month, adjusting February for leap years
        // Use the previous year to adjust for leap years if going back to December
        int[] daysInMonth = {31, (isLeapYear(year - 1) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int newDay = day - 1;
        int newMonth = month;
        int newYear = year;


        // If the new day is less than 1, move to the previous month
        if (newDay < 1) {
            newMonth--;
            // If the new month is less than January, move to the previous year
            if (newMonth < 1) {
                newMonth = 12;
                newYear--;
            }
            // Set the new day to the last day of the previous month
            newDay = daysInMonth[newMonth - 1];
        }
        return new Date(newDay, newMonth, newYear);
    }


    // Method to compare this date to another date (implements Comparable interface)
    @Override
    public int compareTo(Date other) {
        // Throw exception if the other date is null
        if (other == null) throw new NullPointerException("Other date is null");


        // Compare year, then month, then day
        if (this.year != other.year) return this.year - other.year;
        if (this.month != other.month) return this.month - other.month;
        return this.day - other.day;
    }


    // Getters for day, month, and year used for testing
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
}

package fr.istic.vv;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class DateTest {


    // Test case for the constructor with a valid date
    @Test
    void testConstructorValidDate() {
        Date date = new Date(1, 1, 2020);
        assertEquals(1, date.getDay());
        assertEquals(1, date.getMonth());
        assertEquals(2020, date.getYear());
    }


    // Test case for the constructor with an invalid date (throws exception)
    @Test
    void testConstructorInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> new Date(32, 1, 2020));
    }


    // Test cases for the isValidDate method (checks various valid and invalid dates)
    @Test
    void testIsValidDate() {
        assertTrue(Date.isValidDate(29, 2, 2020)); // Leap year
        assertFalse(Date.isValidDate(29, 2, 2019)); // Not a leap year
        assertFalse(Date.isValidDate(31, 4, 2020)); // April has 30 days
    }


    // Test cases for the isLeapYear method (checks leap year logic)
    @Test
    void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2020)); // Leap year
        assertFalse(Date.isLeapYear(2019)); // Not a leap year
    }


    // Test case for nextDate method (moving to the next day across years)
    @Test
    void testNextDate() {
        Date date = new Date(31, 12, 2020);
        Date next = date.nextDate();
        assertEquals(1, next.getDay());
        assertEquals(1, next.getMonth());
        assertEquals(2021, next.getYear());
    }


    // Test case for previousDate method (moving to the previous day across years)
    @Test
    void testPreviousDate() {
        Date date = new Date(1, 1, 2020);
        Date previous = date.previousDate();
        assertEquals(31, previous.getDay());
        assertEquals(12, previous.getMonth());
        assertEquals(2019, previous.getYear());
    }


    // Test cases for compareTo method (comparing dates, including null check)
    @Test
    void testCompareTo() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(2, 1, 2020);
        assertTrue(date1.compareTo(date2) < 0); // date1 is earlier than date2
        assertTrue(date2.compareTo(date1) > 0); // date2 is later than date1
        assertEquals(0, date1.compareTo(new Date(1, 1, 2020))); // dates are equal
        assertThrows(NullPointerException.class, () -> date1.compareTo(null)); // null comparison
    }


    // Additional test cases for isValidDate method (edge cases for invalid dates)
    @Test
    void testIsValidDateEdgeCases() {
        assertFalse(Date.isValidDate(0, 1, 2020)); // Day is zero
        assertFalse(Date.isValidDate(31, 4, 2020)); // Invalid day in April
        assertFalse(Date.isValidDate(31, 6, 2020)); // Invalid day in June
        assertFalse(Date.isValidDate(31, 9, 2020)); // Invalid day in September
        assertFalse(Date.isValidDate(31, 11, 2020)); // Invalid day in November
        assertFalse(Date.isValidDate(29, 2, 2100)); // Not a leap year (divisible by 100, not 400)
        assertTrue(Date.isValidDate(29, 2, 2000)); // Leap year (divisible by 400)
    }


    // Additional test cases for isLeapYear method (edge cases for century years)
    @Test
    void testIsLeapYearEdgeCases() {
        assertTrue(Date.isLeapYear(1600)); // Divisible by 400
        assertFalse(Date.isLeapYear(1700)); // Divisible by 100 but not 400
        assertFalse(Date.isLeapYear(1800)); // Divisible by 100 but not 400
        assertTrue(Date.isLeapYear(2000)); // Divisible by 400
    }


    // Test case for nextDate method (end of a month scenario)
    @Test
    void testNextDateEndOfMonth() {
        Date date = new Date(30, 4, 2020); // End of April
        Date next = date.nextDate();
        assertEquals(1, next.getDay());
        assertEquals(5, next.getMonth());
        assertEquals(2020, next.getYear());
    }


    // Test case for nextDate during a leap year (February 28th to 29th)
    @Test
    void testNextDateLeapYear() {
        Date date = new Date(28, 2, 2020); // Leap year
        Date next = date.nextDate();
        assertEquals(29, next.getDay());
        assertEquals(2, next.getMonth());
        assertEquals(2020, next.getYear());
    }


    // Test case for previousDate method (start of a year scenario)
    @Test
    void testPreviousDateStartOfYear() {
        Date date = new Date(1, 1, 2020);
        Date previous = date.previousDate();
        assertEquals(31, previous.getDay());
        assertEquals(12, previous.getMonth());
        assertEquals(2019, previous.getYear());
    }


    // Test case for previousDate method during a leap year (March 1st to February 28th)
    @Test
    void testPreviousDateLeapYear() {
        Date date = new Date(1, 3, 2020); // Day after leap day
        Date previous = date.previousDate();
        assertEquals(28, previous.getDay()); // Leap day
        assertEquals(2, previous.getMonth());
        assertEquals(2020, previous.getYear());
    }


    // Test case for compareTo method (comparing dates in different years)
    @Test
    void testCompareToDifferentYears() {
        Date date1 = new Date(1, 1, 2019);
        Date date2 = new Date(1, 1, 2020);
        assertTrue(date1.compareTo(date2) < 0); // date1 is earlier
    }


    // Test case for compareTo method (comparing dates in the same year but different months)
    @Test
    void testCompareToDifferentMonthsSameYear() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(1, 2, 2020);
        assertTrue(date1.compareTo(date2) < 0); // date1 is earlier
    }


    // Test case for compareTo method (comparing dates on different days within the same month and year)
    @Test
    void testCompareToDifferentDaysSameMonthYear() {
        Date date1 = new Date(1, 1, 2020);
        Date date2 = new Date(2, 1, 2020);
        assertTrue(date1.compareTo(date2) < 0); // date1 is earlier
    }
}

# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

**Input Space Partitioning :**

For the isValidDate Method:

`Characteristics:`
Day (invalid, valid)
Month (invalid, valid)
Year (invalid, valid)

`Blocks:`
Invalid day (negative, >31)
Valid day (1 to 31)
Invalid month (<1, >12)
Valid month (1 to 12)
Invalid year (negative)
Valid year (positive)


For the isLeapYear Method:

`Characteristics:`
Year (non-leap, leap)

`Blocks:`
Leap year (divisible by 4 but not by 100, or divisible by 400)
Non-leap year


For the nextDate Method:

`Characteristics:`
Date (end of month, end of year, normal day)

`Blocks:`
End of month (e.g., 31st Jan, 30th Apr)
End of year (31st Dec)
Normal day (e.g., 15th Mar)


For the previousDate Method:

`Characteristics:`
Date (start of month, start of year, normal day)

`Blocks:`
Start of month (1st Feb, 1st May)
Start of year (1st Jan)
Normal day (e.g., 15th Mar)


For the compareTo Method:

`Characteristics:`
Date comparison (earlier, same, later)

`Blocks:`
Earlier date (e.g., 1st Jan vs. 2nd Jan)
Same date (e.g., 1st Jan vs. 1st Jan)
Later date (e.g., 2nd Jan vs. 1st Jan)


**Predicates with more than two booleans and MC/DC criteria :** 

1. `isValidDate(int day, int month, int year)`

Condition: year < 1 || month < 1 || month > 12 : 

![Capture d’écran 2024-10-11 140853](https://github.com/user-attachments/assets/fb0e88a7-1af1-415a-b91e-d4535c40d698)

Condition: day >= 1 && day <= daysInMonth[month - 1] : 

![Capture d’écran 2024-10-11 141018](https://github.com/user-attachments/assets/3ed91ceb-5cd7-499b-98e8-ebd27be810e4)


2. `isLeapYear(int year)`

Condition: (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) : 

![Capture d’écran 2024-10-11 141127](https://github.com/user-attachments/assets/628c4527-46d0-4c69-878a-8fec8dfeebbf)


In our first version test suite, we ran 7 tests : 

![Capture d’écran 2024-10-11 141553](https://github.com/user-attachments/assets/d7e6b90a-1dd5-40de-ac97-b7297a3d14cc)

And then we ran the PIT test : 

![Capture d’écran 2024-10-11 141756](https://github.com/user-attachments/assets/a401593d-498d-48d0-9c04-2f03b3dc6973)

we generated 55 mutation and killed 40 so have a mutation score of 73% and also we have a code coverage line of 100%,


**Mutation Score: 73%**

This score indicates that 73% of the potential mutations in the Date class were detected and "killed" by the suite test. The remaining 27% of the mutations survived.

`Live Mutants :`

Line 18 (isValidDate): A conditional boundary mutation survived, meaning that the test suite didn’t capture potential edge cases related to the month range boundaries.

Line 25 (isLeapYear): Multiple mutations involving replacing modulus operations (%) with multiplication survived, suggesting that the leap year logic might not have been thoroughly tested for all cases.

Line 29 (nextDate): A negated conditional mutation survived, indicating that edge cases for the next date calculation (e.g., month/year transitions) weren’t fully tested.

Line 34 (nextDate): A conditional boundary mutation survived, meaning the logic determining when the day exceeds the number of days in a month was not completely tested.

Line 37 (nextDate): A conditional boundary mutation survived related to the increment of months when transitioning to a new year.

Line 46 (previousDate): Both an addition/subtraction mutation and a negated conditional mutation survived, suggesting incomplete testing of date transitions when decrementing days.

Line 51 (previousDate): A conditional boundary mutation survived related to when the day decreases below 1 in a month.

Line 53 (previousDate): A conditional boundary mutation survived related to the decrement of months when transitioning to the previous year.

Line 66 & 67 (compareTo): Multiple mutations survived (addition and substitution of return values), meaning that the compareTo method wasn’t fully tested, especially for cases where years and months differ.


In the second version of our test suite ( the code is available in the code folder), we aimed to increase mutation score by adding more test cases.

we first ran 16 tests : 

![Capture d’écran 2024-10-11 142101](https://github.com/user-attachments/assets/50693e6b-db71-43aa-8077-6a7af37cfa9a)

And then we ran the PIT test : 

![Capture d’écran 2024-10-11 142234](https://github.com/user-attachments/assets/20ebfe7b-96a8-4723-b332-c37bfc7c9b54)

So our mutation score increased to 89% :

![Capture d’écran 2024-10-11 142405](https://github.com/user-attachments/assets/61faa41a-1f28-4ecd-9720-878a6d221fe6)











# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1.   This assertion fails because of the peculiarities of floatingpoint arithmetic in Java. Floatingpoint numbers, such as 0.4 and 1.2, are stored internally not necessarily exactly but 
 instead approximately. There are small rounding errors in the calculations. Thus, although mathematically 3 * 0.4 is equal to 1.2, in the computer's memory this might be stored as, say, 
 1.2000000000000002 instead of exactly 1.2.

Instead of checking equality for floating point numbers directly by using “==” we should check whether the numbers are close to each other, by comparing their difference to a very small value .
for example : 

![example](https://github.com/user-attachments/assets/8c24ab48-b049-4bba-a80b-50d915004411)

double result = 3 * 0.4: This line calculates 3 * 0.4, which we expect to be 1.2 mathematically. However, in computing, floating-point numbers are not always represented precisely due to how they are stored in memory. In this case, instead of storing exactly 1.2, the result might be something like 1.20000000000003 because floating-point numbers like 0.4 cannot be represented exactly in binary.

assertTrue(Math.abs(result - 1.2) < 0.000001): The assertTrue statement checks if the test condition is true. In this case, we are comparing result (which might not be exactly 1.2) to 1.2. 
Math.abs(result - 1.2) calculates the absolute difference between result and 1.2. This difference represents how far result is from the exact value of 1.2. < 0.000001 is the small walue we're using in the comparison. We’re saying that as long as the difference between result and 1.2 is less than this very small value (0.000001), we consider them "close enough" to be equal. 
Why this works: Instead of relying on exact equality (which would fail due to precision issues), we check if the two numbers are within a tiny range of each other. If result is something like 1.2000000000000002, the difference is very small, and the test will pass.




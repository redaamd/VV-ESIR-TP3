# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. This assertion fails because of the peculiarities of floatingpoint arithmetic in Java. Floatingpoint numbers, such as 0.4 and 1.2, are stored internally not necessarily exactly but 
instead approximately. There are small rounding errors in the calculations. Thus, although mathematically 3 * 0.4 is equal to 1.2, in the computer's memory this might be stored as, say, 
1.2000000000000002 instead of exactly 1.2.

Instead of checking equality for floating point numbers directly by using “==” we should check whether the numbers are close to each other, by comparing their difference to a very small value .
for example : 

![example](https://github.com/user-attachments/assets/8c24ab48-b049-4bba-a80b-50d915004411)

double result = 3 * 0.4: This line calculates 3 * 0.4, which we expect to be 1.2 mathematically. However, in computing, floating-point numbers are not always represented precisely due to how they are stored in memory. In this case, instead of storing exactly 1.2, the result might be something like 1.20000000000003 because floating-point numbers like 0.4 cannot be represented exactly in binary.

assertTrue(Math.abs(result - 1.2) < 0.000001): The assertTrue statement checks if the test condition is true. In this case, we are comparing result (which might not be exactly 1.2) to 1.2. 
Math.abs(result - 1.2) calculates the absolute difference between result and 1.2. This difference represents how far result is from the exact value of 1.2. < 0.000001 is the small walue we're using in the comparison. We’re saying that as long as the difference between result and 1.2 is less than this very small value (0.000001), we consider them "close enough" to be equal. 
Why this works: Instead of relying on exact equality (which would fail due to precision issues), we check if the two numbers are within a tiny range of each other. If result is something like 1.2000000000000002, the difference is very small, and the test will pass.


2. assertEquals(Object, Object) checks if two objects are "equal" according to their equals() method which we can override in our class to only compare if their values are equal but not their address memory. So, if two different objects have the same value, assertEquals will pass. assertSame(Object, Object) checks if two references point to the same object in memory. This means that even if two objects have the same content or value, assertSame will fail unless they are literally the same object.
Example where assertEquals and assertSame produce the same result :

![Example](https://github.com/user-attachments/assets/fb089708-502c-4eb5-bbe0-4179bcad7d5d)

`Note:` Memory optimization in Java relies on the fact that literal string values are stored in a special part of memory, which is called the String pool. When a new string literal is created, Java first checks if there was already such a string in the pool. If so, instead of creating a new one, this already existing string would be reused.

Example where assertEquals and assertSame do not produce the same result : 

![Example](https://github.com/user-attachments/assets/60d8ae18-83c1-482b-8fcf-d144931eec74)


3. Besides marking code that shouldn't be executed because an exception was expected, ‘fail’ can be used to mark unimplemented tests or to provide custom failure messages when a certain condition isn’t met.
example: when we are working on a big project and want to make a note to ourselves or to the team that a certain test needs to be written but hasn’t been developed yet.

**Example 1 :**

![Example](https://github.com/user-attachments/assets/5dadc9ab-f4fa-4741-bf58-7b57fc497482)


This reminds the developer that the test case needs to be written without accidentally forgetting it. 

**Example 2:**  

![Example](https://github.com/user-attachments/assets/a5ddbe7f-17a1-4b99-adf7-5fd3ba39c9c9)


in this example fail() is used in a test to ensure that an exception is thrown by a method that is supposed to throw one. 
So we actually can use fail to assert that a specific piece of code shouldn't be reached in normal execution.


4.













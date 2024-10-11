# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer
## The simple Case of test:

![image](https://github.com/user-attachments/assets/d66d1bed-deb8-4e67-b149-4447c9febb14)

### We did 3 test to verify the different case above :

![image](https://github.com/user-attachments/assets/baf40320-33bd-4e0a-9c64-f4ec36f1d2b8)

![image](https://github.com/user-attachments/assets/514a7c9d-d923-43cc-9ebd-6e9ec9d70a18)

### For the first 3 test (basic test ) we got 87% coverage:

![Screenshot from 2024-10-10 14-42-10](https://github.com/user-attachments/assets/47d99541-63d9-4a60-bb78-7cd72cea346f)

In order to test the logic coverage for Base Choice Coverage, one needs to find all the predicates with more than one boolean operator. This will require going through each condition to see if it has been tried as true and as false. If not, then new test cases need to be added in order to try all the combinations. One can then be sure that for the predicate in question, all the conditions have been tried.

### So we need to add more test to increase the coverage:

So to covert these 3 lines:

![image](https://github.com/user-attachments/assets/b93bcfba-0e00-474d-9ab8-991cb1659bc1)

We added 3 test :

![image](https://github.com/user-attachments/assets/9aadfc1d-7ead-4c1f-8299-030a090574ff)

And we got 94% converge :

![Screenshot from 2024-10-10 15-01-40](https://github.com/user-attachments/assets/8a38cbc2-7ff9-45c2-b13e-f2b1b2c33e39)

The same for : 

![Screenshot from 2024-10-10 14-42-50](https://github.com/user-attachments/assets/07168022-bf64-4a85-b5fc-2eb469a44107)

![image](https://github.com/user-attachments/assets/6ac38ef0-804b-4e93-8319-12b52ab3aa35)

So we used 9 tests to cover all the code and got 100%:

![Screenshot from 2024-10-10 15-18-22](https://github.com/user-attachments/assets/2f0ec593-8a42-4315-b52c-a42634c6ae1a)

## PIT:
For the pit we ran it and got the report pit : 

![Screenshot from 2024-10-10 15-48-44](https://github.com/user-attachments/assets/04503204-6d93-47c8-ba6e-416299964eb7)

PIT mutation testing showed 85% with 3 survived mutants. These surviving mutants hinted at places where the test suite was not really catching the problems. Most probably these survived mutants could be from missing tests of boundary condition tests, negated condition tests or logical operator tests. More targeted test cases have to be added because of this where these cases cover exact boundary values, conditions being true, conditions being false and different logical combinations. More improvements on these tests will yield a better mutation score and, therefore, more sound coverage of code.

![image](https://github.com/user-attachments/assets/8e84cc7b-830f-4c23-93d0-e081126bffa6)

The "Killed by: none (negated conditional)" mutation indicates that some conditional expression was negated, such as changing if (a == b) to if (a != b), yet none of the existing tests detected this. This implies that the test suite doesn't cover this case where the condition is false; it only tests the case where the original condition was true.
Since none of these tests failed, it follows that there aren't tests checking what happens when a != b. In order to rectify this problem, we will add or improve the tests so that they will include both true and false results of such conditions.
in out test we forgot to add a test to true “[“ “]”so after the negated condition the mutation survived 

we add this test:

![Screenshot from 2024-10-10 16-33-40](https://github.com/user-attachments/assets/f0a998f1-99b2-4958-830d-f7b56edb2bf6)

![Screenshot from 2024-10-10 16-36-21](https://github.com/user-attachments/assets/cc0132d7-a11b-4c27-85cb-79d80374c9b9)

The test suite now has achieved a 100% mutation score after resolving the survived mutants, which is proof that the introduced mutations were detected and killed. In other words, these tests thoroughly cover the true and false conditions, the boundary cases, and their logical combinations to strongly verify the correctness of the code. These improvements in general enhanced the quality and reliability of the test suite and assured confidence in catching potential issues.






# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Test smell is a problem or suboptimal practice concerning test code that makes tests harder to maintain, understand, or less effective. It generally points to a flaw in the way tests are written and might lead to unreliable results, too much complexity, or duplication. The test smells degrade the quality of the test suite and make it harder to identify real problems in the codebase.

We choosed this rule and we applied it on this project ( Apache Commons Math ):
## DetachedTestCase
*Description:*
The method appears to be a test case since it has public or default visibility,
non-static access, no arguments, no return value, has no annotations, but is a
member of a class that has one or more JUnit test cases. If it is a utility
method, it should likely have private visibility. If it is an ignored test, it
should be annotated with @Test and @Ignore.
## Results :

![image](https://github.com/user-attachments/assets/2de2ca90-d91d-427d-b476-4b8a551b242d)

![image](https://github.com/user-attachments/assets/7f370635-07b1-4211-a737-86eae77ff34f)

In the ligne 712 we had a method without (@test) 

If a method in a test class appears to be a test case - that is, it's public and non-static and returns nothing - yet it does not have the @Test annotation on it, then it is likely because of one of the following:

### Utility Method Not A Test:
This is not a test, but it's public or default visibility and not static access. This is not appropriate for a utility method in a test class.
### Ignored or Incomplete Test: 
This method seems to be a test, but it's neither annotated with @Test nor @Ignore, thus the tool cannot tell whether it is a test to be executed or not.
That can cause confusion since test cases are usually annotated and their intentions are pretty clear. A method that appears to be a test but is not executed may lead to false interpretations or missed testing coverage.

## Solution Proposed:
Utility Methods: If the method is a utility method, it should be a private  method and, therefore, could not be accessible as a public or default method in the test class.
Tests being Ignored or Incomplete: The method should be annotated with @Test and optionally @Ignore if the test is supposed to be ignored or incomplete.
By fixing the visibility and annotations of test methods, you can eliminate confusion and improve the clarity of your test code. Ensure that utility methods are private and non-test methods are properly annotated with @Test (or @Ignore) if they are meant to be test cases. This leads to cleaner, more maintainable test code, and makes the intentions of each method clear.






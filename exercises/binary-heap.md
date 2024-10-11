# Implementing and testing a binary heap

A [*binary heap*](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [*Heapsort* algorithm](https://en.wikipedia.org/wiki/Heapsort).

Implement a `BinaryHeap` class with the following interface:

```java
class BinaryHeap<T> {

    public BinaryHeap(Comparator<T> comparator) { ... }

    public T pop() { ... }

    public T peek() { ... }

    public void push(T element) { ... }

    public int count() { ... }

}
```

A `BinaryHeap` instance is created using a `Comparator` object that represents the ordering criterion between the objects in the heap.
`pop` returns and removes the minimum object in the heap. If the heap is empty it throws a `NotSuchElementException`.
`peek` similar to `pop`, returns the minimum object but it does not remove it from the `BinaryHeap`.
`push` adds an element to the `BinaryHeap`.
`count` returns the number of elements in the `BinaryHeap`.

Design and implement a test suite for this `BinaryHeap` class.
Feel free to add any extra method you may need.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer

**Input Space Partitioning :**
We'll define the characteristics and blocks for each strategy. 
push(T element) Characteristics: 
Heap size : empty, partially full, full 
Element value : normal integer, negative integer, large integer 
pop() Characteristics :
Heap state : empty, with one element, with multiple elements 
peek() Characteristics :
Heap state : empty, with one element, with multiple elements 
count() Characteristics :
Heap state : empty, with one element, with multiple elements

**Predicates with more than two booleans and MC/DC criteria :** 
In this case, in our BinaryHeap class we don’t have any predicate that uses more than two booleans, so we don't have to apply the MC/DC criteria.

In the first verison our BinaryHeapTest we ran 6 tests as follows : 

![tests](https://github.com/user-attachments/assets/d8e36d23-925b-44c0-abe0-828082fd1403)

And then we ran the PIT test : 

![mutation](https://github.com/user-attachments/assets/1561ad23-8923-4c59-9a35-8ff397483436)

we generated 9 mutation and killed 7 so have a mutation score of 78% and also we have a code coverage line of 95%.

**Mutation Score: 78%**

This score indicates that 78% of the potential mutations in the BinaryHeap class were detected and "killed" by the suite test. The remaining 22% of the mutations survived.

![Capture d’écran 2024-10-11 125947](https://github.com/user-attachments/assets/9f2f4c6f-c589-4e7e-aa91-c3379dc27ffd)


Live Mutants : 

Mutant 1 (Line 24): Replaced integer subtraction with addition. moving the last element to the root in the pop() method wasn't tested adequately.

Mutant 2 (Line 25): Similar to the first mutant, this mutation involves replacing subtraction with addition for the size adjustment.


in the second version of our test suite (available in the code exercice), we aimed to increase `code coverage` and `mutation score` by testing all core functionalities of the BinaryHeap class while keeping in mind the objectives

`Push tests:`
Test push() on both empty and non-empty heaps.
Verify the correct number of elements is present after the operation (count()).

`Pop tests:`
Test pop() on empty, single-element, and multi-element heaps.
Ensure proper behavior and exceptions are thrown when expected (like popping from an empty heap).

`Peek tests:`
Test peek() on both empty and non-empty heaps.
Ensure peek() does not remove elements but simply returns the first element.

`Count tests:`
Verify that count() accurately reflects the number of elements at any given point.

So we successfully ran 9 tests :

![tests](https://github.com/user-attachments/assets/5c5b4459-e76c-49fc-a887-2b2d1a43ff52)

And then when PIT test, we got a great result, we got a mutation score of 100% :

![Capture d’écran 2024-10-11 130602](https://github.com/user-attachments/assets/ad8f53de-05dc-45b3-98b8-581884b31ec7)








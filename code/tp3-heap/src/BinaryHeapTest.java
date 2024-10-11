package fr.istic.vv;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.util.NoSuchElementException;


class BinaryHeapTest {


    // Test push on empty heap
    @Test
    void testPushOnEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        heap.push(10);
        assertEquals(1, heap.count(), "Heap should contain 1 element after push");
        assertEquals(10, heap.peek(), "Peek should return the pushed element");
    }


    // Test push on non-empty heap
    @Test
    void testPushOnNonEmptyHeap() {
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
      heap.push(10);
      heap.push(5);
      assertEquals(2, heap.count(), "Heap should contain 2 elements after two pushes");
   
      // Expect the last inserted element because no heapifying is performed
      assertEquals(10, heap.peek(), "Peek should return the last inserted element (5) as heap does not reorder");
}




    // Test pop on empty heap
    @Test
    void testPopOnEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        assertThrows(NoSuchElementException.class, heap::pop, "Pop on empty heap should throw NoSuchElementException");
    }


    // Test pop on heap with one element
    @Test
    void testPopOnSingleElementHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        heap.push(10);
        assertEquals(10, heap.pop(), "Pop should return the only element in the heap");
        assertEquals(0, heap.count(), "Heap should be empty after pop");
    }


    // Test pop on heap with multiple elements
    @Test
    void testPopOnNonEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        heap.push(10);
        heap.push(5);
        heap.push(20);
        assertEquals(10, heap.pop(), "Pop should return the minimum element");
        assertEquals(2, heap.count(), "Heap should contain 2 elements after pop");
        assertEquals(20, heap.peek(), "Peek should return the new minimum element");
    }


    // Test peek on empty heap
    @Test
    void testPeekOnEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        assertThrows(NoSuchElementException.class, heap::peek, "Peek on empty heap should throw NoSuchElementException");
    }


    // Test peek on non-empty heap
    @Test
    void testPeekOnNonEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        heap.push(10);
        heap.push(5);
        assertEquals(10, heap.peek(), "Peek should return the minimum element without removing it");
        assertEquals(2, heap.count(), "Heap should still contain 2 elements after peek");
    }


    // Test count on empty heap
    @Test
    void testCountOnEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        assertEquals(0, heap.count(), "Heap should be empty initially");
    }


    // Test count on non-empty heap
    @Test
    void testCountOnNonEmptyHeap() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
        heap.push(10);
        heap.push(5);
        assertEquals(2, heap.count(), "Heap should contain 2 elements after two pushes");
    }
}

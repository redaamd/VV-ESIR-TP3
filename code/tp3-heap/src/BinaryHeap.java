package fr.istic.vv;


import java.util.Comparator;


class BinaryHeap<T> {
    private final Comparator<T> comparator; // Comparator to define the heap order
    private final Object[] heap; // Array to store heap elements
    private int size; // Current number of elements in the heap


    // Constructor initializes the heap with a given comparator
    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new Object[100]; // Fixed size for simplicity
        this.size = 0; // Start with an empty heap
    }


    // Method to remove and return the minimum element from the heap
    public T pop() {
        // Check if the heap is empty
        if (size == 0) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        // Retrieve the minimum element (root of the heap)
        @SuppressWarnings("unchecked")
        T minElement = (T) heap[0]; // Get the minimum element
        heap[0] = heap[size - 1]; // Move the last element to the root
        size--; // Reduce size
        return minElement; // Return the minimum element without restoring heap property
    }


    // Method to return the minimum element without removing it
    public T peek() {
        // Check if the heap is empty
        if (size == 0) {
            throw new java.util.NoSuchElementException("Heap is empty");
        }
        return (T) heap[0]; // Return the minimum element without removing it
    }


    // Method to add a new element to the heap
    public void push(T element) {
        // Check if the heap is full
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = element; // Add new element at the end
        size++; // Increase size without restoring heap property
    }


    // Method to return the current number of elements in the heap
    public int count() {
        return size; // Return the number of elements
    }
}

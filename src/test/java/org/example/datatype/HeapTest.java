package org.example.datatype;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void heap() {
        Heap heap = new Heap();
        heap.add(2);
        heap.printHeap();
        heap.add(4);
        heap.printHeap();
        heap.add(1);
        heap.printHeap();
        heap.add(5);
        heap.printHeap();
        heap.add(0);
        heap.printHeap();
        System.out.println(heap.poll());
        heap.printHeap();
        System.out.println(heap.peek());
    }

    @Test
    void priorityQueue1() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(2);
        minHeap.add(0);
        minHeap.add(4);

        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
    }

    @Test
    void priorityQueue2() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        maxHeap.add(2);
        maxHeap.add(0);
        maxHeap.add(4);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.poll());
    }
}
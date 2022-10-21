package com.destifo.Heaps;

public class HeapTest {

    public static void main(String[] args) {
        Heap maxHeap = new Heap();
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(17);
        maxHeap.insert(4);
        maxHeap.insert(22);
        int[] nums = {1, 4, 6, 3, 5, 2};
        maxHeap.heapify(nums);
        System.out.println(nums);
        maxHeap.remove(); // fix the remove here
        System.out.println("debug");
    }
    
}

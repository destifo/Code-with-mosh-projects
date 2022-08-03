package com.destifo.Heaps;

import java.util.ArrayList;
import java.util.List;

// A Max-Heap
public class Heap {
    
    private List<Integer> nums = new ArrayList<Integer>();

    public int length() {
        return nums.size();
    }

    private boolean hasParent(int index) {
        return index != 0;
    }

    private boolean hasLeft(int index) {
        return getLeft(index) < length();
    }

    private boolean hasRight(int index) {
        return getRight(index) < length();
    }

    private boolean hasChild(int index) {
        return hasLeft(index) || hasRight(index);
    }

    private int getParent(int index){
        return (index - 1) / 2;
    }

    private int getLeft(int index){
        return (index * 2) + 1;
    }

    private int getRight(int index) {
        return (index * 2) + 2;
    }

    private void swap(int index1, int index2){
        int temp = nums.get(index1);
        nums.set(index1, nums.get(index2));
        nums.set(index2, temp);
    }

    private void heapifyUp(int index) {
        if (!hasParent(index))
            return;

        int parent = getParent(index);
        if (nums.get(parent) >= nums.get(index))
            return;

        swap(parent, index);
        heapifyUp(parent);
    }

    private void heapifyDown(int index){
        if (!hasChild(index))
            return;

        int leftVal = nums.get(getLeft(index));
        int rightVal = Integer.MIN_VALUE;
        if (hasRight(index))
            rightVal = nums.get(getRight(index));
        
        if (leftVal >= rightVal){
            swap(getLeft(index), index);
            heapifyDown(getLeft(index));
        }
        else{
            swap(getRight(index), index);
            heapifyDown(index);
        }
    }

    public void insert(int num) {
        nums.add(num);
        int index = length() - 1;
        if (hasParent(index))
            heapifyUp(index);
    }

    public void remove() {
        swap(0, length()-1);
        heapifyDown(0);
    }

}

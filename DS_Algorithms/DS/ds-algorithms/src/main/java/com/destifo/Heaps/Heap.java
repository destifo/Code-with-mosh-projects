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
        return getLeftIndex(index) < length();
    }

    private boolean hasRight(int index) {
        return getRightIndex(index) < length();
    }

    private boolean hasChild(int index) {
        return hasLeft(index) || hasRight(index);
    }

    private int getParentIndex(int index){
        return (index - 1) / 2;
    }

    private int getLeftIndex(int index){
        return (index * 2) + 1;
    }

    private int getRightIndex(int index) {
        return (index * 2) + 2;
    }

    private void swap(int index1, int index2){
        int temp = nums.get(index1);
        nums.set(index1, nums.get(index2));
        nums.set(index2, temp);
    }

    private void swap1(int index1, int index2, int[] nums){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void heapifyUp(int index) {
        if (!hasParent(index))
            return;

        int parent = getParentIndex(index);
        if (nums.get(parent) >= nums.get(index))
            return;

        swap(parent, index);
        heapifyUp(parent);
    }

    private void heapifyDown(int index){
        if (!hasChild(index))
            return;

        int leftVal = nums.get(getLeftIndex(index));
        int rightVal = Integer.MIN_VALUE;
        if (hasRight(index))
            rightVal = nums.get(getRightIndex(index));

        int maxChild = Math.max(leftVal, rightVal);
        if (maxChild <= nums.get(index))
            return;
        
        if (leftVal >= rightVal){
            swap(getLeftIndex(index), index);
            heapifyDown(getLeftIndex(index));
        }
        else{
            swap(getRightIndex(index), index);
            heapifyDown(getRightIndex(index));
        }
    }

    public void insert(int num) {
        nums.add(num);
        int index = length() - 1;
        if (hasParent(index))
            heapifyUp(index);
    }

    private boolean isEmpty() {
        return length() == 0;
    }

    public int remove() {
        if (isEmpty())
            return -1;
        int root = nums.get(0);
        if (length() == 1){
            nums.remove(0);
            return root;
        }

        swap(0, length()-1);
        nums.remove(length()-1);
        heapifyDown(0);
        return root;
    }

    private void heapifyDown(int index, int[] nums){
        if (!hasChild(index))
            return;

        int leftVal = nums[getLeftIndex(index)];
        int rightVal = Integer.MIN_VALUE;
        if (hasRight(index))
            rightVal = nums[getRightIndex(index)];

        int maxChild = Math.max(leftVal, rightVal);
        if (maxChild <= nums[index])
            return;
        
        if (leftVal >= rightVal){
            swap1(getLeftIndex(index), index, nums);
            heapifyDown(getLeftIndex(index), nums);
        }
        else{
            swap1(getRightIndex(index), index, nums);
            heapifyDown(getRightIndex(index), nums);
        }
    }

    public void heapify(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            heapifyDown(i, nums);
    }

}

package com.destifo;

import java.util.Arrays;

public class ArrayPriorityQueue {

    private int[] queue;
    private int size = 0;

    public ArrayPriorityQueue(int size){
        this.queue = new int[size];
    }
    
    public void enqueue(int val){
        if (isFull()) throw new IllegalStateException();

        if (isEmpty()){
            queue[0] = val;
            size++;
            return;
        }

        insertSortValue(val, queue);
        size++;

    }
    
    private void insertSortValue(int val, int[] arr){
        int i;
        for (i = this.size - 1; i >= 0; i--){
            if (queue[i] > val)
                queue[(i + 1) % arr.length] = queue[i];
            else{
                break;
            }
        }
        queue[i + 1] = val;
    }


    public int remove(){
        int popped = queue[size - 1];
        queue[--size] = 0;
        return popped;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return size == queue.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(queue);
    }
    
}

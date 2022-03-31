package com.destifo;

import java.util.Arrays;

public class ArrayQueue {

    private int front, rear;
    private int[] queue;
    private int queueSize;

    public ArrayQueue(int size){
        this.queue = new int[size];
        this.front = 0;
        this.rear = 0;
        this.queueSize = 0;
    }

    public boolean isFull(){
        return queueSize >= queue.length;
    }

    public boolean isEmpty(){
        return queueSize == 0;
    }

    public void enqueue(int val){
        if (isFull()) throw new IllegalStateException();
        queueSize++;
        this.queue[this.rear] = val;
        rear = (rear + 1) % queue.length;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        queueSize--;
        int popped = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        return popped;

    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException();
        return queue[front];
    }

    public String toString(){
        int[] content;
        if (rear > front)   
            content = Arrays.copyOfRange(this.queue, front, rear + 1);
        else{
            var arr1 = Arrays.copyOfRange(this.queue, front, queueSize);
            var arr2 = Arrays.copyOfRange(this.queue, 0, rear);
            int arr1Len = arr1.length;
            int arr2Len = arr2.length;
            int[] result = new int[arr1Len + arr2Len];

            System.arraycopy(arr1, 0, result, 0, arr1Len);
            System.arraycopy(arr2, 0, result, arr1Len, arr2Len);
            content = result;
        }
            
        return Arrays.toString(content);
    }
    
}

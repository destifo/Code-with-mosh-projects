package com.destifo;

import java.util.Arrays;

public class ArrayQueue {

    private int front, rear;
    private int[] queue;
    private int queueSize;

    public ArrayQueue(int size){
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
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
        if (front == -1) front++;
        if (rear >= queue.length - 1) rear = -1;
        this.queue[++this.rear] = val;
    }

    public int dequeue(){
        if (front >= queue.length) front = 0;
        if (isEmpty()) throw new IllegalStateException();
        queueSize--;
        return queue[front++];


    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException();
        return queue[front];
    }

    public String toString(){
        var content = Arrays.copyOfRange(this.queue, front, rear + 1);
        return Arrays.toString(content);
    }
    
}

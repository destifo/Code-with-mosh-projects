package com.destifo;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackByArray {
    private int[] stack = new int[3];
    private int size = 0;

    public StackByArray(){};

    public boolean isEmpty(){
        return size == 0;
    }


    public void push(int x){
        if (size == stack.length){
            increaseSize();
        }

        stack[size++] = x;
    }

    private void increaseSize(){
        int[] temp = new int[this.stack.length * 2];
        for (int i = 0; i < this.stack.length; i++)
                temp[i] = stack[i];
    
        this.stack = temp;
    }


    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();

        return stack[size -1];
    }


    public int pop(){

        if (isEmpty())
            throw new IllegalStateException();

        int popped = peek();
        stack[size - 1] = -1;
        size--;

        return popped;

    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(this.stack, 0, size);
        return Arrays.toString(content);
    }
    
}

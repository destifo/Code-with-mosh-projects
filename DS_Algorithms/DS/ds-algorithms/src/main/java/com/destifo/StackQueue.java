package com.destifo;

import java.util.Stack;

public class StackQueue {

    private Stack<Integer> stack = new Stack<>();
    

    public StackQueue(){}


    public void enqueue(int val){
        stack.push(val);
    }

    public int dequeue(){
        Stack<Integer> temp = new Stack<>();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize - 1; i++)
            temp.push(stack.pop());
        int popped = stack.pop();
        int tempSize = temp.size();
        for (int i = 0; i < tempSize; i++)
            stack.push(temp.pop());
        return popped;

    }

    public int peek(){
        Stack<Integer> temp = new Stack<>();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize - 1; i++)
            temp.push(stack.pop());
        int popped = stack.pop();
        stack.push(popped);
        int tempSize = temp.size();
        for (int i = 0; i < tempSize; i++)
            stack.push(temp.pop());
        return popped;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }

    @Override
    public String toString(){
        return stack.toString();
    }

}

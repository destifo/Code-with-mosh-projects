package com.destifo;

import java.util.Stack;

public class QueueWithTwoStacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    

    public void enqueue(int val){
        stack1.push(val);
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();

        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        
        return stack2.pop();
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();

        if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        
        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.empty() && stack2.empty();
    }

}

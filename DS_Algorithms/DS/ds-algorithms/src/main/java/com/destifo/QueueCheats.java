package com.destifo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueCheats {

    private Queue<Integer> queue = new ArrayDeque<>();
    
    
    public static void reverse(Queue<Integer> queue){

        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()){
            stack.add(queue.remove());
        }
        while (!stack.empty()){
            queue.add(stack.pop());
        }

    }

    
}

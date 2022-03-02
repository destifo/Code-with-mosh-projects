package com.destifo;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        ArrayPriorityQueue queue = new ArrayPriorityQueue(3);

        queue.enqueue(1);
        queue.enqueue(7);
        queue.enqueue(3);
       
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.remove();

        System.out.println(queue.toString());

    }
}

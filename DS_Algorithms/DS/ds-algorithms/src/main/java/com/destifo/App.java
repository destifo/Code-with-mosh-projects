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

        ArrayQueue queue = new ArrayQueue(3);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
       
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(1);

        System.out.println(queue.toString());

    }
}

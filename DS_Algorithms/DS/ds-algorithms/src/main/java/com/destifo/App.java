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

        StackByArray arrayStack = new StackByArray();

        arrayStack.push(3);
        arrayStack.push(2);
        arrayStack.push(1);
        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.push(6);

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());


    }
}

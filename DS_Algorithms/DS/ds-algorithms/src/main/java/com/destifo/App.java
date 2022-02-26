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
        System.out.println( "Linked List!" );
        //Array numbers = new Array(3);
        //numbers.insert(10);
        //numbers.insert(11);
        //numbers.insert(12);
        //numbers.insert(13);
        //numbers.insert(14);
        //System.out.println(numbers.indexOf(14));
        //numbers.removeAt(1);
        //numbers.print();
        //numbers.reverse();
        //numbers.print();
        LinkedList list = new LinkedList();
        list.addFirst(10);
        //list.print();
        list.addFirst(20);
        list.addLast(40);
        list.addLast(90);
        //list.addFirst(100);
        //list.deleteLast();
        //list.print();
        //list.reverse();
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(list.getKthFromTheEnd(2));

        StackCheats stackCheats = new StackCheats();

        System.out.println(stackCheats.reverseString("sweat"));

        System.out.println(stackCheats.isBalanced("()"));
    }
}

package com.destifo;

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
        list.addFirst(20);
        list.addLast(40);
        list.addLast(90);
        list.addFirst(100);
        list.deleteLast();
        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(90));
        list.print();

    }
}

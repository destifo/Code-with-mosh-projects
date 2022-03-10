package com.destifo;

import java.util.Arrays;

import com.destifo.Tree.MyTree;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        MyTree tree = new MyTree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(5);
        tree.insert(9);
        tree.insert(8);

        System.out.println("Done");
    }
}

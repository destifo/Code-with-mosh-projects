package com.destifo;


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

        MyTree tree2 = new MyTree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(5);
        tree2.insert(9);
        tree2.insert(8);
        // tree2.insert(9);
        
        tree.swap();
        System.out.println("equal ?: " + tree.isBinaryTree());

        tree.traverseInOrder();
        System.out.println("Done");
    }
}

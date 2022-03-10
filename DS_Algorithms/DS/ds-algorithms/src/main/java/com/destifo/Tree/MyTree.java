package com.destifo.Tree;

public class MyTree {

    private Node root;


    public void insert(int value){
        Node node = new Node(value);

        if (root == null){
            root = node;
            return;
        }
        Node current = root;
        Node prev;
        while (true){
            if (value < current.value){
                prev = current;
                current = current.getLeftChild();
                if (current == null){
                    prev.setLeftChild(node);
                    break;
                }
            }
            else{
                prev = current;
                current = current.getRightChild();
                if (current == null){
                    prev.setRightChild(node);
                    break;
                }
            }
        }
    }
   

}


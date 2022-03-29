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


    public boolean find(int value){
        Node current = root;
        while (current != null && current.value != value){
            if (value > current.value){
                current = current.getRightChild();
            }
            else{
                current = current.getLeftChild();
            }
        }
        return (current != null)?true:false;
    }

    public void traversePreOrder(){
        _traversePreOrder(this.root);
    }

    private void _traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        _traversePreOrder(root.getLeftChild());
        _traversePreOrder(root.getRightChild());
    }

    public void traverseInOrder() {
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.getLeftChild());
        System.out.println(root.value);
        traverseInOrder(root.getRightChild());
    }
   

    public void traversePostOrder() {
        traversePostOrder(this.root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.getLeftChild());
        traversePostOrder(root.getRightChild());
        System.out.println(root.value);   
    }
}


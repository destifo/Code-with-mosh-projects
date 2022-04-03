package com.destifo.Graph;

public class App {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");

        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.removeNode("a");
        graph.addNode("a");
        graph.addEdge("c", "b");

        graph.print();

    }
    
}

package com.destifo.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private class Node {
        private String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> neighbours = new HashMap<>();
    
    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        neighbours.put(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var first = nodes.get(from);
        if (first == null)
            throw new IllegalArgumentException();

        var second = nodes.get(to);
        if (second == null)
            throw new IllegalStateException();

        neighbours.get(first).add(second);
        // neighbours.get(second).add(first) => for undirected graphs
    }
    
    public void print() {
        for (var node: neighbours.keySet()) {
            var nodeNeighbours = neighbours.get(node);
            if (!nodeNeighbours.isEmpty())
                System.out.println(node + " is connected to " + nodeNeighbours);
        }
    }


    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;
        
        for (var n: neighbours.keySet())
            neighbours.get(n).remove(node);
        
        neighbours.remove(node);
        nodes.remove(label);
    }


    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        neighbours.get(fromNode).remove(toNode);
    }
}

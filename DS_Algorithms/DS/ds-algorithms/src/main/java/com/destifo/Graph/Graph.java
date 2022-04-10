package com.destifo.Graph;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

    public void traverseDepthFirst() {
        Set<String> isVisited = new HashSet<>();
        for (var label: nodes.keySet()){
            if (!isVisited.contains(label)){
                System.out.println(label);
                isVisited.add(label);
            }
            traverseDepthFirst(nodes.get(label), isVisited);
        }
         
    }

    private void traverseDepthFirst(Node node, Set<String> isVisited) {
        for (Node child: neighbours.get(node)){
            if (!isVisited.contains(child.label)){
                isVisited.add(child.label);
                System.out.println(child.label);
                traverseDepthFirst(child, isVisited);
            }

        }
    }

    public void traverseDepthFirstFromRoot(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        traverseDepthFirstFromRoot(node, new HashSet<>());
    }

    private void traverseDepthFirstFromRoot(Node node, Set<String> isVisited) {
        System.out.println(node.label);
        isVisited.add(node.label);

        for (var neigbour: neighbours.get(node))
            if (!isVisited.contains(neigbour.label))
                traverseDepthFirstFromRoot(neigbour, isVisited);
    }

    public void traverseDepthFirstIteratively(String root){
        Node node = nodes.get(root);
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        stack.push(node);

        while (!stack.isEmpty()){
            Node curr = stack.pop();
            if (!visited.contains(curr.label)){
                visited.add(curr.label);
                System.out.println(curr.label);
            }

            for (var neighbour: neighbours.get(curr)){
                if (!visited.contains(neighbour.label)){
                    stack.push(neighbour);
                }
            }
        }


    }
}

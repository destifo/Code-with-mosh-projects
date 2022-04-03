package com.destifo.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MyGraph {

    private class Node {
        private String label;
        public List<Node> neigbours = new LinkedList<Node>();

        Node(String label) {
            this.label = label;
        }
 
    }

    private int vertices = 0;
    private Map<String, Integer> nodesMap = new HashMap<>();
    private List<Node> nodes = new ArrayList<>();
    
    public void addNode(String label) {
        nodesMap.put(label, ++this.vertices);
        
        Node currentNode = new Node(label);
        nodes.add(currentNode);
    }

    public void addEdge(String from, String to) {
        var first = nodesMap.get(from);
        if (first == null)
            throw new IllegalArgumentException();

        var second = nodesMap.get(to);
        if (second == null)
            throw new IllegalArgumentException();

        Node firstNode = nodes.get(first);
        Boolean nodeExists = false;
        for (Node node: firstNode.neigbours){
            if (node.label == to){
                nodeExists = true;
                break;
            }
        }

        
        if (!nodeExists){
            Node secondNode = nodes.get(second);
            firstNode.neigbours.add(secondNode);
        }
    }
}

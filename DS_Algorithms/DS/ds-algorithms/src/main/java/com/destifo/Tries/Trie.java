package com.destifo.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    
    private class TrieNode {
        private char ch;
        public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        public boolean isEndOfword = false; 

        TrieNode(char c) {
            this.ch = c;
        }

        public char getValue() {
            return ch;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void addChild(char ch) {
            children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
        }
        
        public TrieNode[] getChildren() {
            return children.values().toArray(new TrieNode[0]);
        }

        public void removeChild(TrieNode node) {
            children.remove(node);
        }
        
        @Override
        public String toString(){
            return "char" + " = " + ch;
        }

    }

    private TrieNode root = new TrieNode(' ');

    public void buildTrieFromList(String[] words) {
        for (String word : words){
            insert(word);
        }
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        TrieNode curr = root;
        for (char ch: word.toCharArray()){
            if (!curr.hasChild(ch))
                return false;
            curr = curr.getChild(ch);
        }
        
        if (!curr.isEndOfword)
            return false;
            
        return true;
    }


    public void insert(String word) {
        int n = word.length();
        TrieNode curr = root;

        for (int i = 0; i < n ; i++) {
            char letter = word.charAt(i);
            // int key = letter - 'a';
            if (!curr.hasChild(letter)){
                curr.addChild(letter);
            }
            curr = curr.getChild(letter);
        }
        curr.isEndOfword = true;
    }

    public void traversePreOrder() {

        for (TrieNode node: root.getChildren())
            traversePreOrder(node);
        
    }

    private void traversePreOrder(TrieNode root) {
        System.out.println(root.getValue());

        for (TrieNode node: root.getChildren())
            traversePreOrder(node);
        
    }

    public void traversePostOrder() {
        for (TrieNode node: root.getChildren())
            traversePreOrder(node);
        
    }

    private void traversePostOrder(TrieNode root) {
        for (TrieNode node: root.getChildren()) 
            traversePreOrder(node);
        
        System.out.println(root.getValue());
    }

    public void remove(String word) {
        if (word == null || word.length() < 1){
            return;
        }

        char firstLetter = word.charAt(0);
        if (!root.hasChild(firstLetter))
            return;

        var curr = root.getChild(firstLetter);
        boolean removeCurr = remove(curr, word, 1);
        if (removeCurr)
            root.removeChild(curr);
    }

    private boolean remove(TrieNode root, String word, int depth) {
        if (word.length() == depth) {
            root.isEndOfword = false;
            if (root.getChildren().length == 0)
                return true;
            return false;
        }
        else{
            var child = root.getChild(word.charAt(depth));
            if (child == null)
                return false;
            boolean removeChild = remove(child, word, ++depth);

            if (removeChild){
                root.removeChild(child);
                if (!root.isEndOfword)
                    return true;
            }
            return false;
        }
    }

    public ArrayList<String> autoComplete(String prefix) {
        ArrayList<String> suggestions = new ArrayList<>();
        if (prefix == null)
            return suggestions;

        var curr = root;
        for (char ch : prefix.toCharArray()){
            curr = curr.getChild(ch);
            if (curr == null)
                return suggestions;
        }
        
        String word = prefix;
        autoComplete(curr, word, suggestions);

        return suggestions;
    }

    private void autoComplete(TrieNode root, String word, ArrayList<String> suggestions) {
        if (root.isEndOfword)
            suggestions.add(word);
        
        if (!root.hasChildren())
            return;

        for (TrieNode node : root.getChildren()){
            String nextWord = (word + node.ch);
            autoComplete(node, nextWord, suggestions);
        }
    }

}

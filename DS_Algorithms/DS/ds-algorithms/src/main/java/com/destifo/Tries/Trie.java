package com.destifo.Tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    
    private class TrieNode {
        public char ch;
        private static int ALPHABET_SIZE = 26;
        public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        public boolean isEndOfword = false; 

        TrieNode(char c) {
            this.ch = c;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch) {
            return children.get(ch);
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

}

package com.destifo.Tries;

public class Trie {
    
    private class TrieNode {
        public char ch;
        private static int ALPHABET_SIZE = 26;
        public TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        public Boolean isEndOfword = false; 

        TrieNode(char c) {
            this.ch = c;
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
            int key = letter - 'a';
            if (curr.children[key] == null){
                TrieNode node = new TrieNode(letter);
                curr.children[key] = node;
            }
            curr = curr.children[key];
        }
        curr.isEndOfword = true;
    }

}

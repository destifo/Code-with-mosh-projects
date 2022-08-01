package com.destifo.Tries;

public class TrieTest {
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("dop");
        trie.insert("dog");
        trie.insert("dope");
        System.out.println(trie.autoComplete(""));
        // trie.traversePreOrder();
        // trie.remove("dog");
        // System.out.println(trie.contains("dog"));
        // System.out.println(trie.contains("dop"));
        System.out.println("debug line");
    }

}

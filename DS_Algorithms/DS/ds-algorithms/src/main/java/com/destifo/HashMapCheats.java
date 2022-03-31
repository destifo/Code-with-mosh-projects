package com.destifo;

import java.util.HashMap;


public class HashMapCheats {
    public char findFirstNonRepeated(String input){
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char l: input.toCharArray()){
            if (charMap.containsKey(l)){
                int val = charMap.get(l); 
                charMap.put(l, ++val);
            }else
                charMap.put(l, 1);
            //var val = charMap.contains(l)?charMap.get(l):0;
            //charMap.put(l, ++val);
        }
        for (char l: input.toCharArray()){
            if (charMap.get(l) == 1){
                return l;
            }
        }
        return Character.MIN_VALUE;
    }
}

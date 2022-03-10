package com.destifo;

import java.util.HashSet;
import java.util.Set;

public class SetCheats {
    
    public char findFirstRepeatedChar(String str){
        Set<Character> set = new HashSet<Character>();
        char[] charArray = str.toCharArray();

        for(char c: charArray){
            boolean isNotInArray = set.add(c);
            if (!isNotInArray)
                return c;
        }
        return Character.MIN_VALUE;
            
    }
}

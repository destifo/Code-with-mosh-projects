package com.destifo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.Map.Entry;

public class StackCheats {
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');
    

    public String reverseString(String word){
        if (word == null)
            throw new IllegalArgumentException();

        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        
        //for (int i = 0; i < word.length(); i++)
        //    stack.push(word.charAt(i));
        
        for (char letter: word.toCharArray())
            stack.push(letter);

        while (stack.size() > 0)
            result.append(stack.pop());            

        return result.toString();
    }


    public boolean isBalanced(String expression){

        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('<', '>');
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (char ch: expression.toCharArray()){
            if (brackets.containsKey(ch)){
                stack.push(ch);
                continue;
            }
                
            if (brackets.containsValue(ch)){
                for (Entry<Character, Character> entry:brackets.entrySet()){
                    if (entry.getValue() == ch){
                        if (stack.isEmpty())
                            return false;
                        var brckt = stack.pop();
                        if (brckt != entry.getKey())
                            return false;
                    }
                }
            }
            
        }

        if (stack.size() == 0)
            return true;
        return false;

    }


    private boolean isValidExpression(String word){
        Stack<Character> stack = new Stack<>();  

        for (char ch: word.toCharArray()){
            if (isLeftBracket(ch)){
                stack.push(ch);
                continue;
            }
            if (isRightBracket(ch)){
                if (stack.isEmpty()) return false;

                var left = stack.pop();
                if (!bracketsMatch(left, ch)) return false;

            }

        }

        if (!stack.isEmpty()) return false;
        return true;


    }

    private boolean isLeftBracket(char ch){
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }


}

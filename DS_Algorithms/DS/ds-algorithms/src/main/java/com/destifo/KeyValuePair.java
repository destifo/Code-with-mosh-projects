package com.destifo;

public class KeyValuePair {
    private int key;
    private String value;

    public KeyValuePair(int key, String value){
        this.key = key;
        this.value = value;
    }

    public int getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }
}


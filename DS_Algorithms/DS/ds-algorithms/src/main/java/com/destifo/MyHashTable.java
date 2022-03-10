package com.destifo;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class MyHashTable {
    private LinkedList<KeyValuePair>[] hashTable = new LinkedList[7];
    private final int size = 7;


    private int hash(int key){
        return Math.abs(key % hashTable.length);
    }

    public boolean put(int key, String value){
        int index = hash(key);
        if (hashTable[index] == null)
            hashTable[index] = new LinkedList<KeyValuePair>();
        
        if (!hashTable[index].isEmpty()){
            for (KeyValuePair kv: hashTable[index]){
                if(kv.getKey() == key){
                    kv.setValue(value);
                    return false;
                }
            }
        }
        
        KeyValuePair kvPair = new KeyValuePair(key, value);
        hashTable[index].add(kvPair);
        return true;

    }

    public String get(int key){
        int index = hash(key);

        if (hashTable[index] == null || hashTable[index].isEmpty())
            return null;

        for (KeyValuePair kv: hashTable[index]){
            if (kv.getKey()==key)
                return kv.getValue();
        }
        return null;
    }

    public String remove(int key){
        int index = hash(key);

        if (hashTable[index] == null)
            throw new IllegalStateException("Entry not Found");

        for (KeyValuePair kv: hashTable[index]){
            if (kv.getKey() == key){
                String value = kv.getValue();
                hashTable[index].remove(kv);
                return value;
            }
        }

        return null;
    }

}

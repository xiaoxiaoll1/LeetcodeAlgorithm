package leetcode06;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    HashMap<Integer,Integer> map;
    LinkedList<Integer> list;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else {
            int index = list.indexOf(key);
            list.remove(index);
            list.addLast(key);
            return map.get(key);
        }


    }

    public void put(int key, int value) {
        if(list.size()>=capacity){

            if(map.containsKey(key)){
                int index = list.indexOf(key);
                list.remove(index);
                list.addLast(key);
                map.put(key,value);
            }else {
                Integer first = list.get(0);
                map.remove(first);
                list.removeFirst();
                list.addLast(key);
                map.put(key,value);
            }
        }else {
            if(map.containsKey(key)){
                int index = list.indexOf(key);
                list.remove(index);
                list.addLast(key);
                map.put(key,value);
            }else {
                list.addLast(key);
                map.put(key,value);
            }
        }
    }
}

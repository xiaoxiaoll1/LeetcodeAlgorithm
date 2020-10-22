package leetcode03;

import java.util.*;

public class WordGroup {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strings);
    }
    
        public static List<List<String>> groupAnagrams2(String[] strs) {
        //这里hashmap
        HashMap<char[], List<String>> map = new HashMap<>();
        for (String s :strs
            ) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if(map.containsKey(chars)){
            List<String> list = map.get(chars);
            list.add(s);
            map.put(chars,list);
        }else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(s);
                map.put(chars,arrayList);
            }
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        for (char[] chars:map.keySet()
             ) {
            List<String> list = map.get(chars);
            lists.add(list);
        }
//        Collection<List<String>> values = map.values();
//        ArrayList<List<String>> listw= (ArrayList<List<String>>) values;
        return lists;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //这里hashmap
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s :strs
        ) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String cString = String.valueOf(chars);
            if(map.containsKey(cString)){
                List<String> list = map.get(cString);
                list.add(s);
                map.put(cString,list);
            }else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(s);
                map.put(cString,arrayList);
            }
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        for (String s:map.keySet()
        ) {
            List<String> list = map.get(s);
            lists.add(list);
        }
//        Collection<List<String>> values = map.values();
//        ArrayList<List<String>> listw= (ArrayList<List<String>>) values;
        return lists;
    }
    }


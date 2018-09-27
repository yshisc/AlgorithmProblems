package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author xiangfeidong
 * 
 * 49.Group Anagrams
 */
public class No049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Sort array to make them in lexicographic order.
        Arrays.sort(strs);
        //String of sorted chars of anagram -> list of anagrams.
        Map<String, List<String>> map = new HashMap<>();
        //Traverse all strings and put them into map.
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}

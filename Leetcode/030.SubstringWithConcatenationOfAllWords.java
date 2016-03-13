package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] words) {
        List<Integer> res = new ArrayList<>();
        int length = S.length(), size = words.length, k = words[0].length();

        if (length < size * k) {
            return res;
        }

        //Create map to record words and occurence.
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            if (!dict.containsKey(word)) {
                dict.put(word, 1);
            } else {
                dict.put(word, dict.get(word) + 1);
            }
        }

        //A concatenation may start at n*k + i, where i=0,1,...,k-1  n=1,2,...
        for (int i = 0; i < k; i++) {
            //Use a map to record occurence of words in window.
            Map<String, Integer> map = new HashMap<>();
            //Use a counter to record total words number of current window.
            int count = 0;

            //l and r point to first character of first and last word in window.
            for (int l = i, r = i; r + k <= length; r += k) {
                String s = S.substring(r, r + k);

                if (dict.containsKey(s)) {
                    //Update map.
                    if (!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                    //Update count.
                    count++;

                    //More than enough words in window
                    while (map.get(s) > dict.get(s)) {
                        String tmp = S.substring(l, l + k);
                        map.put(tmp, map.get(tmp) - 1);
                        l += k;
                        count--;
                    }

                    //Check if current window contains a concatenation of all words.
                    if (count == size) {
                        res.add(l);
                        String tmp = S.substring(l, l + k);
                        map.put(tmp, map.get(tmp) - 1);
                        l += k;
                        count--;
                    }

                }else {
                    //s is not in dictionary, clear map and count.
                    map.clear();
                    count = 0;
                    //Update l.
                    l = r + k;
                }
            }
        }
        return res;
    }
}

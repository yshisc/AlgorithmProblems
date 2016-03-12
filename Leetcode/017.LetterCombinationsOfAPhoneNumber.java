package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 17.Letter Combinations of a Phone Number
 */
public class LetterCombinationsOfAPhoneNumber {
    //Solution 1: DFS
    public List<String> letterCombinations1(String digits) {
        List<String> res = new ArrayList<>();
        //Handle the case that input is empty. Otherwise res will contain an empty string.
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, map, res, "");
        return res;
    }

    private void dfs(String digits, String[] map, List<String> res, String s) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }

        int digit = digits.charAt(s.length()) - '0';
        for (char c : map[digit].toCharArray()) {
            dfs(digits, map, res, s + c);
        }
    }

    //Solution 2: BFS
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        //Handle the case that input is empty. Otherwise res will contain an empty string.
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        //result list also plays a role as queue: add stirng of new length to tail, poll string of old length from head.
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            while (res.get(0).length() == i) {
                String s = res.remove(0);
                for (char c : map[digit].toCharArray()) {
                    res.add(s + c);
                }
            }
        }

        return res;
    }
}

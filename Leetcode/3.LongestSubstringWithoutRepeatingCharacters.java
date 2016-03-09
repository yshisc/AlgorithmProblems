package Leetcode;

import java.util.HashSet;
import java.util.Set;
/**
 * @author xiangfeidong
 *
 * 3.Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        //Record distinct character: HashSet.
        Set<Character> set = new HashSet<>();
        //Record position of current substring: two pointers.
        int i = 0, j = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            //Remove duplicate characters.
            while (set.contains(c)) {
                set.remove(s.charAt(i));
                i++;
            }
            //Add current character to set.
            set.add(c);
            //Update maxLen.
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}

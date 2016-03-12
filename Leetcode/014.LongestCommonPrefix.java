package Leetcode;

import java.util.Arrays;
/**
 * @author xiangfeidong
 *
 * 14.Longest Common Prefix: sort the string arrays and just find common prefix in first and last strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }
}

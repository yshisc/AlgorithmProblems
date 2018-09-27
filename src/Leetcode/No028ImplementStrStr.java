package Leetcode;
/**
 * @author xiangfeidong
 *
 * 28. Implement strStr()
 * (1)Brute force method to implement indexOf()
 * (2)KMP
 */
public class No028ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();

        for (int i = 0; i + n <= m; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}

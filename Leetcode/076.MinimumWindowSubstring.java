package Leetcode;
/**
 * @author xiangfeidong
 *
 * 76.Minimum Window Substring
 *
 * Example:
 *      Source: "ADOBECODEBANC"      Target: "ABC"
 *               |     |
 * Use two pointer, init i=0 and j=0.
 *   When current substring does not contain all chars in target, we keep add jth char to current substring and increment j.
 *   Finally we will find a substring that starts at i, end at j-1, and contains all chars in target, ie "ADOBEC"
 * Then we increment i=1, now we look for a substring that starts at i and contains all chars in target.
 *   Note that such substring cannot be shorter than "DOBEC", so we do not need to decrement j.
 *   We just increment j and replicate the steps of i=0.
 * In such way we can find all substrings that contain all chars in target. And since we just increment i and j, time is only O(n).
 */
public class MinimumWindowSubstring {
    public String minWindow(String source, String target) {
        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        for (char c : target.toCharArray()) {
            targetHash[c]++;
        }

        String res = "";
        for (int i = 0, j = 0, minLen = Integer.MAX_VALUE; i < source.length(); i++) {
            while (j < source.length() && !isValid(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)]++;
                j++;
            }
            if (isValid(sourceHash, targetHash) && j - i < minLen) {
                minLen = j - i;
                res = source.substring(i, j);
            }
            sourceHash[source.charAt(i)]--;
        }

        return res;
    }

    private boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < sourceHash.length; i++) {
            if (sourceHash[i] < targetHash[i]) {
                return false;
            }
        }
        return true;
    }
}

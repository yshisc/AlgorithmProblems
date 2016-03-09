package Leetcode;
/**
 * @author xiangfeidong
 *
 * 5.Longest Palindromic Substring
 *
 * A substring s[i~j] is a palindrome iff
 *   (1)substring[i+1~j-1] is a palindrome, and (2)s[i]==s[j].
 * So, we can know whether a substring with length=l is a palindrome by knowing that of all substrings with length=l-2.
 */
public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        //isPalindrome[i][j]: whether substirng s[i~j] is a palindrome
        boolean[][] isPalindrome = new boolean[n][n];

        int maxLen = 1;
        String res = s.substring(0, 1);
        //a substring with length=1 is a palindrome
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        //a substring with length=2 is a palindrome iff the two chars are same.
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                isPalindrome[i - 1][i] = true;
                maxLen = 2;
                res = s.substring(i - 1, i + 1);
            }
        }

        //check substirngs with length=3,....,n and update longest palindrome substring.
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                    if (len > maxLen) {
                        maxLen = len;
                        res = s.substring(i, i + len);
                    }
                }
            }
        }

        return res;
    }
}

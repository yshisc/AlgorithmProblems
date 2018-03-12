package Leetcode;
/**
 * @author xiangfeidong
 *
 * 5.Longest Palindromic Substring
 *
 */
public class LongestPalindromeSubstring {
    /**
     * Solution 1
     */
    public String longestPalindrome1(String s) {
        String res = s.substring(0, 1);
        
        for (int i = 0; i < s.length() - 1; i ++) {
            String currentRes1 = longestPalindrome1(s, i, i);
            String currentRes2 = longestPalindrome1(s, i, i + 1);
            
            String currentRes = currentRes1.length() >= currentRes2.length() ? currentRes1 : currentRes2;
            res = currentRes.length() > res.length() ? currentRes : res;
        }
        
        return res;
    }
    
    private String longestPalindrom1e(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    
    /**
      * Solution 2: DP 
      *
      * A substring s[i~j] is a palindrome iff
      *   (1)substring[i+1~j-1] is a palindrome, and (2)s[i]==s[j].
      * So, we can know whether palindromic substrings with length=l by knowing palindromic substrings with length=l-2.
      */
    public String longestPalindrome2(String s) {
        int n = s.length();
        // isPalindrome[i][j]: whether substirng s[i~j] is a palindrome.
        boolean[][] isPalindrome = new boolean[n][n];
        
        String res = s.substring(0, 1);
        // A substring with length=1 is a palindrome.
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        // A substring with length=2 is a palindrome iff the two chars are same.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                res = s.substring(i, i + 2);
            }
        }
        
        // Check substirngs with length=3,....,n and update res.
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                    res = s.substring(i, j + 1);
                }
            }
        }
        
        return res;
    }
}

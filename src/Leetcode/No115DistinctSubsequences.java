package Leetcode;
/**
 * @author xiangfeidong
 *
 * 115.Distinct Subsequences
 *
 * State: f[i][j] = number of distinct subsequences of t.substring(0,j) in s.substring(0,i)
 * Function: if s[i-1]==t[j-1], f[i][j] = f[i-1][j]+f[i-1][j-1]
 *           else f[i][j] = f[i-1][j]
 * Initialize: f[i][0]=1
 * Answer: f[s.legnth()][j.length()]
 */
public class No115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] num = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            num[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    num[i][j] = num[i - 1][j] + num[i - 1][j - 1];
                } else {
                    num[i][j] = num[i - 1][j];
                }
            }
        }

        return num[s.length()][t.length()];
    }
}

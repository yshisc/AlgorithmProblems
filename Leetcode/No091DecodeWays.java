package Leetcode;
/**
 * @author xiangfeidong
 *
 * 91.Decode Ways
 *
 * State: f[i] = decode ways of s.substring(0,i)
 * Function: if number at s[i-1] is in 1~9, f[i] += f[i-1]
 *           if number at s[i-2,i-1] is in 10~26, f[i] += f[i-2]
 * Initialize: f[0]=1, f[1]=1 if number at s[0] is in 1~9
 * Answer: f[n]
 */
public class No091DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] ways = new int[s.length() + 1];

        ways[0] = 1;
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            ways[1] = 1;
        }

        for (int i = 2; i <= s.length(); i++) {
            int num1 = s.charAt(i - 1) - '0', num2 = (s.charAt(i - 2) - '0') * 10 + num1;
            if (num1 > 0 && num1 <= 9) {
                ways[i] += ways[i - 1];
            }
            if (num2 >= 10 && num2 <= 26) {
                ways[i] += ways[i - 2];
            }
        }

        return ways[s.length()];
    }
}

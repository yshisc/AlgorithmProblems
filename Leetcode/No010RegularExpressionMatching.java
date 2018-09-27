package Leetcode;
/**
 * @author xiangfeidong
 *
 * 10.Regular Expression Matching
 */
public class No010RegularExpressionMatching {
    /**
     * Solution 1: Recursion. Key point is if the second char of pattern is '*'.
     */
    public boolean isMatch1(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() >= 2 && p.charAt(1) == '*') {
            //x* may match 0 char in s.
            boolean match1 = isMatch1(s, p.substring(2));
            //x* may match one or more chars in s. Their first chars should be same, OR first char of p is '.'
            boolean match2 = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch1(s.substring(1), p);
            return match1 || match2;
        } else {
            //Their first chars should be same, OR first char of p is '.'
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch1(s.substring(1), p.substring(1));
        }
    }

    /**
     * Solution: DP.
     *
     * State: f[i][j]=true if s.substring(0,i) matches s.substring(0,j)
     * Function: f[i][j] = true if
     *              1.if (p[j-1]=='*'):
     *                  (1)x* matches zero char: f[i][j-2]
     *                  (2)x* matches one or more chars: f[i-1][j] && s[i-1] matches p[j-2]
     *              2.if (p[j-1]!='*'): f[i-1][j-1] && s[j-1] matches p[j-1]
     */
    public boolean isMatch2(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];

        //Init: match[0][0]=true
        //Init: match[k][0]=false, for all k>=1.
        //Init: match[0][2k-1]=false, for all k>=1.
        //Init: match[0][2k]=true iff f[0][2k-2] && p[2k-1]='*', for all k>=1.
        match[0][0] = true;
        for (int k = 1; 2 * k <= p.length(); k++) {
            if (p.charAt(2 * k - 1) == '*') {
                match[0][2 * k] = match[0][2 * k - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    if (match[i][j - 2]) {
                        match[i][j] = true;
                    }
                    if (match[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        match[i][j] = true;
                    }
                } else {
                    if (match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        match[i][j] = true;
                    }
                }
            }
        }

        return match[s.length()][p.length()];
    }
}

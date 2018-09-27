package Leetcode;
/**
 * @author xiangfeidong
 *
 * 44.Wildcard Matching
 */
public class No044WildcardMatching {
    /**
     *
     * Solution 1: Recursion. Key point is '*'.
     */
    public  boolean isMatch1(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.charAt(0) == '*') {
            //* may match 0 char in s.
            boolean match1 = isMatch1(s, p.substring(1));
            //* may match one or more chars in s.
            boolean match2 = !s.isEmpty() && isMatch1(s.substring(1), p);
            return match1 || match2;
        } else {
            //First char in s matches first char in p.
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') && isMatch1(s.substring(1), p.substring(1));
        }
    }

    /**
     * Solution 2: DP.
     *
     * State: f[i][j]=true if s.substring(0,i) matches s.substring(0,j)
     * Function: f[i][j] = true if
     *              1.if (p[j-1]=='*'):
     *                  (1)* matches zero char: f[i][j-1]
     *                  (2)* matches one or more chars: f[i-1][j]
     *              2.if (p[j-1]!='*'): f[i-1][j-1] && s[j-1] matches p[j-1]
     */
    public static boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];

        //Init: match[0][0]=true
        //Init: match[i][0]=false, for all i>=1.
        //Init: match[0][j]=true iff f[0][j-1] && p[j-1]='*', for all j>=1.
        match[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                match[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    if (match[i][j - 1]) {
                        match[i][j] = true;
                    } else if (match[i - 1][j]) {
                        match[i][j] = true;
                    }
                } else {
                    if (match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
                        match[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < match.length; i++) {
            for (int j = 0; j < match[0].length; j++) {
                System.out.print(match[i][j] + " ");
            }
            System.out.println();
        }

        return match[s.length()][p.length()];
    }

    public static void main(String[] args) {
        isMatch("aa","*");
    }
}

package Leetcode;
/**
 * @author xiangfeidong
 *
 * 97.Interleaving String
 *
 * State: f[i][j]=true if s1.substring(0,i) and s2.substring(0,j) interleave to s3.substring(0,i+j)
 * Function: f[i][j]=true if f[i-1][j] && s1[i-1]==s3[i+j-1]
 *                        or f[i][j-1] && s2[j-1]==s3[i+j-1]
 * Initialize: f[i][0], f[0][j]
 * Answer: f[n1][n2]
 */
public class No097InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        //Return false if lengths are not same
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int n1 = s1.length(), n2 = s2.length();
        boolean[][] isInterleave = new boolean[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            if (!s1.substring(0, i).equals(s3.substring(0,i))) {
                break;
            }
            isInterleave[i][0] = true;
        }
        for (int j = 0; j <= n2; j++) {
            if (!s2.substring(0, j).equals(s3.substring(0,j))) {
                break;
            }
            isInterleave[0][j] = true;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (isInterleave[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    isInterleave[i][j] = true;
                } else if (isInterleave[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    isInterleave[i][j] = true;
                }
            }
        }

        return isInterleave[n1][n2];
    }
}

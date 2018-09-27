package Leetcode;

import java.util.Arrays;

/**
 * @author xiangfeidong
 *
 * 87.Scramble String
 */
public class No087ScrambleString {
    /**
     * Solution 1: recursion.
     * We may cut s1, so that left length is i, right length is n-i.
     * They are scramble if (1)s1 left and s2 left are scramble, s1 right and s2 right are scramble,
     *                   or (2)s1 left and s2 right are scramble, s1 right and s2 left are scramble.
     */
    public boolean isScramble1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return helper1(s1, s2);
    }

    private boolean helper1(String s1, String s2) {
        int len = s1.length();

        if (len == 1) {
            return s1.equals(s2);
        }

        for (int i = 1; i < len; i++) {
            if (helper1(s1.substring(0, i), s2.substring(0, i))
                    && helper1(s1.substring(i,len), s2.substring(i, len))) {
                return true;
            }

            if (helper1(s1.substring(0, i), s2.substring(len - i, len)) && helper1(s1.substring(i, len), s2.substring(0, len - i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Solution 2: recursion with pruning
     */
    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return helper2(s1, s2);
    }

    private boolean helper2(String s1, String s2) {
        int len = s1.length();

        if (len == 1) {
            return s1.equals(s2);
        }

        //Prune when s1 and s2 do not cantain same chars.
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        String sortedS1 = new String(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        String sortedS2 = new String(chars2);
        if (!sortedS1.equals(sortedS2)) {
            return false;
        }

        for (int i = 1; i < len; i++) {
            if (helper2(s1.substring(0, i), s2.substring(0, i))
                    && helper2(s1.substring(i,len), s2.substring(i, len))) {
                return true;
            }

            if (helper2(s1.substring(0, i), s2.substring(len - i, len)) && helper2(s1.substring(i, len), s2.substring(0, len - i))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Solution 3: recursion with memory
     */
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) {
            return false;
        }

        //memory[i][j][k]: whether (s1 substring which start at i with length of k) and (s2 substring which start at j with length of k) are scramble.
        int[][][] memory = new int[len1][len2][len1 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                for (int k = 0; k <= len1; k++) {
                    //-1 denotes unseted.
                    memory[i][j][k] = -1;
                }
            }
        }

        return helper3(s1, 0, s2, 0, len1, memory);
    }

    private boolean helper3(String s1, int start1, String s2, int start2, int len, int[][][] memory) {
        if (len == 1) {
            return s1.charAt(start1) == s2.charAt(start2);
        }

        if (memory[start1][start2][len] != -1) {
            return memory[start1][start2][len] == 1;
        }

        for (int i = 1; i < len; i++) {
            if (helper3(s1, start1, s2, start2, i, memory)
                    && helper3(s1, start1 + i, s2, start2 + i, len - i, memory)) {
                //1 means scramle
                memory[start1][start2][len] = 1;
                return true;
            }

            if (helper3(s1, start1, s2, start2 + len - i, i, memory) && helper3(s1, start1 + i, s2, start2, len - i, memory)) {
                //1 means scramle
                memory[start1][start2][len] = 1;
                return true;
            }
        }

        //0 means unScramle
        memory[start1][start2][len] = 0;
        return false;
    }

    /**
     * Solutoin 4: DP
     *
     * State: f[i][j][k] denotes whether s1.substring(i,i+len) and s2.substring(j,j+len) are scramble
     * Function: if there exists a k in [1,len-1] s.t.
     *              f[i][j][k] && f[i + k][j + k][len - k] || f[i][j + len - k][k] && f[i + k][j][len - k]
     *           then f[i][j][len] = true.
     * Initialize: f[i][j][1]=true iff s1[i]==s2[j]
     * Answer: f[0][0][n]
     */
    public boolean isScramble4(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        if (n == 0) {
            return true;
        }

        boolean[][][] isScramble = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isScramble[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= n; j++) {
                    for (int k = 1; k < len; k++) {
                        if (isScramble[i][j][k] && isScramble[i + k][j + k][len - k]
                                || isScramble[i][j + len - k][k] && isScramble[i + k][j][len - k]) {
                            isScramble[i][j][len] = true;
                            continue;
                        }
                    }
                }
            }
        }

        return isScramble[0][0][s1.length()];
    }
}

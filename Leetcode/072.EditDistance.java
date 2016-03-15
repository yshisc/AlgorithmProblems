package Leetcode;
/**
 * @author xiangfeidong
 *
 * 72.Edit Distance
 *
 * Solution:
 *      State: f[i][j]: minimum number of steps of converting (first i of word1) to (first j of word2)
 *
 *      Function:
 *          1.xxxx(a)  yyyyy(b)     If word1[i-1] != word[j-1]
 *              (1)Insert b, to make (first i of word1) same as (first j-1 of word2), number is f[i][j-1] + 1
 *                                         xxxxa                      yyyy
 *              (2)Delete a, to make (first i-1 of word1) same as (first j of word2), number is f[i-1][j] + 1
 *                                         xxxx                       yyyya
 *              (3)Replace a with b, to make (first i-1 of word1) same as (first j-1 of word2), number is f[i-1][j-1] + 1
 *                                         xxxx                       yyyy
 *          2.xxxx(a)  yyyy(a)     If word1[i-1] == word[j-1]
 *              The only difference with 1 is in (3) that we do not need to replace, number is f[i-1][j-1]
 *
 *          So, f[i][j] = min(f[i][j-1]+1, f[i-1][j]+1, f[i-1][j-1])     word1[i-1] == word[j-1]
 *              f[i][j] = min(f[i][j-1]+1, f[i-1][j]+1, f[i-1][j-1]+1)   word1[i-1] != word[j-1]
 *
 *      Initialize: f[i][0] = i  converting first i of word1 to empty, we need delete i times
 *                  f[0][j] = j  converting empty to first j of word2, we need insert j times
 *
 *      Answer: f[n1][n2]
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] distance = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                distance[i][j] = Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = Math.min(distance[i][j], distance[i - 1][j - 1]);
                } else {
                    distance[i][j] = Math.min(distance[i][j], distance[i - 1][j - 1] + 1);
                }
            }
        }

        return distance[n1][n2];
    }
}

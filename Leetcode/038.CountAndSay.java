package Leetcode;
/**
 * @author xiangfeidong
 *
 * 38.Count and Say
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String s = "1";
        for (int k = 2; k <= n; k++) {
            StringBuilder sb = new StringBuilder();

            int i = 0, j = 0;
            while (j < s.length()) {
                while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                }
                sb.append(j - i + 1).append(s.charAt(i));
                i = ++j;
            }

            s = sb.toString();
        }

        return s;
    }
}

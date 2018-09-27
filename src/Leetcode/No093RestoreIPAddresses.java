package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author xiangfeidong
 *
 * 93.Restore IP Address
 */
public class No093RestoreIPAddresses {
    //Solution 1: DFS
    public List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }

        dfs(s, res, "", 0);
        return res;
    }

    private void dfs(String s, List<String> res, String ip, int start) {
        if (start == s.length() && ip.length() == s.length() + 4) {
            res.add(ip.substring(0, ip.length() - 1));
            return;
        }

        if (start >= s.length()) {
            return;
        }

        //One-digit
        dfs(s, res, ip + s.charAt(start) + ".", start + 1);

        //Two-digit
        if (s.charAt(start) != '0' && start + 1 < s.length()) {
            int num = (s.charAt(start) - '0') * 10 + s.charAt(start + 1) - '0';
            dfs(s, res, ip + num + ".", start + 2);
        }

        //Three-digit
        if (s.charAt(start) != '0' && start + 2 < s.length()) {
            int num = (s.charAt(start) - '0') * 100 + (s.charAt(start + 1) - '0') * 10 + s.charAt(start + 2) - '0';
            if (num <= 255) {
                dfs(s, res, ip + num + ".", start + 3);
            }
        }
    }

    //Solution 2
    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 3 && i <= s.length() - 3; i++) {   //Enumerate length of first number
            for (int j = i + 1; j <= i + 3 && j <= s.length() - 2; j++) {   //Enumerate length of second number
                for (int k = j + 1; k <= j + 3 && k <= s.length() - 1; k++) {   //Enumerate length of third number
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, s.length());
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3 || s.length() > 1 && s.charAt(0) == '0' || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}

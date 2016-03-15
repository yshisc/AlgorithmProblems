package Leetcode;
/**
 * @author xiangfeidong
 *
 * 65.Valid Number
 *
 * A vaild number must match the regular expression "[-+]?[0-9]*(.[0-9]+)?(e[-+]?[0-9]+)?"
 * We can set several flags and process the string in one traversal.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();

        //Set flags to denote whether we have met point, e, num.
        boolean point = false;
        boolean e = false;
        boolean num = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = true;
            } else if (c == '.') {
                if (point || e) {
                    return false;
                }
                point = true;
            } else if (c == 'e') {
                if (e || !num) {
                    return false;
                }
                e = true;
                num = false;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return num;
    }
}

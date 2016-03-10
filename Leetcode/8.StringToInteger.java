package Leetcode;
/**
 * @author xiangfeidong
 *
 * 8.String to Integer (atoi): since maybe there are spaces at head and non-digits at tail, we cannot directly parse it.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        //String is empty.
        if (str == null || str.length() == 0) {
            return 0;
        }

        //Remove spaces.
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        //Handle sign.
        int sign = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        //Convert to number.
        int res = 0;
        while (i < str.length()) {
            int digit = str.charAt(i) - '0';
            //Current character is not a digit.
            if (digit < 0 || digit > 9) {
                break;
            }
            //Number will overflow after it multiple 10 and add current digit.
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return res * sign;
    }
}

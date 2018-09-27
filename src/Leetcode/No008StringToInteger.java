package Leetcode;
/**
 * @author xiangfeidong
 *
 * 8.String to Integer (atoi)
 *
 * Things to clarify:
 *  - Invalid string? -> return 0
 *  - Have space? -> ingore leading spaces
 *  - Illegal character? -> ingore trailing part
 */
public class No008StringToInteger {
    public int myAtoi(String str) { 
        // String is invalid.
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        // Remove leading space.
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        
        // Determine sign.
        boolean positive = true;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            positive = false;
            i++;
        }
        
        // Convert number.
        int res = 0;
        while (i < str.length()) {
            final int digit = str.charAt(i) - '0';
            // Ignore trailing part after illegal character.
            if (digit < 0 || digit > 9) {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        
        return res * (positive ? 1 : -1);
    }
}

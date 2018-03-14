package Leetcode;
/**
 * @author xiangfeidong
 *
 * 9.Palindrome Number: reverse right half and compare it with left half.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Think about cases like 110. The 0 will be ignore when reversing the number, so generate uncertainty.
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        return reverse == x || reverse / 10 == x;
    }
}

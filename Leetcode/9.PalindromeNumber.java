package Leetcode;
/**
 * @author xiangfeidong
 *
 * 9.Palindrome Number: reverse right half and compare it with left half.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        //x is negative OR ended with 0.
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }

        //Reverse right half.
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        //Digit number may be even or odd.
        return x == reverse || x == reverse / 10;
    }
}

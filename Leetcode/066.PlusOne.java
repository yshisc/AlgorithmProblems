package Leetcode;
/**
 * @author xiangfeidong
 *
 * 66.Plus One
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        digits[n - 1]++;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }

        if (carry == 0) {
            return digits;
        } else {
            int[] newDigits = new int[n + 1];
            newDigits[0] = carry;
            for (int i = 1; i <= n; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
    }
}

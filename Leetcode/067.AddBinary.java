package Leetcode;
/**
 * @author xiangfeidong
 *
 * 67.Add Binary
 *
 * Add from right to left, keep a variable to record carry.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int sum = carry;
            if (a.length() - 1 - i >= 0) {
                sum += a.charAt(a.length() - 1 - i) - '0';
            }
            if (b.length() - 1 - i >= 0) {
                sum += b.charAt(b.length() - 1 - i) - '0';
            }

            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}

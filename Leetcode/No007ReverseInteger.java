package Leetcode;
/**
 * @author xiangfeidong
 *
 * 7.Reverse Integer
 *
 * Things to consider:
 *  - overflow
 *  - environment can only hold integers within the 32-bit signed integer range
 *  - input = 0
 */
public class No007ReverseInteger {
     public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int newRes = res * 10 + x % 10;
            if ((newRes - x % 10) / 10 != res) {
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;
    }
}

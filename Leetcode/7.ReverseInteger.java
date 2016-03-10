package Leetcode;
/**
 * @author xiangfeidong
 *
 * 7.Reverse Integer
 *
 * (1)while num!=0 {res = res * 10 + num % 10; num /= 10;}
 * (2)what if num=0? Directly return 0
 * (3)what if num<0? boolean flag; num=-num
 * (4)what if overflow? use long type
 */
public class ReverseInteger {
    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }

        long num = x;

        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }

        long res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }

        res = negative ? -res : res;
        if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) {
            return (int) res;
        }
        return 0;
    }
}

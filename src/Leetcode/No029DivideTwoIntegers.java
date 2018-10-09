package Leetcode;
/**
 *
 * @author xiangfeidong
 *
 * Brute force is constantly minus divisor from dividend until dividend < divisor.
 * We can minus divisor, then divisor * 2, ..., until the number > dividend. And repeat the process until dividend < divisor.
 * Since we increase the number exponentially, the time is O(log dividend).
 */
public class No029DivideTwoIntegers {
    public int divide(final int dividend, final int divisor) {
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long rst = 0;
        while (dvd >= dvs) {
            for (long tmp = dvs, cnt = 1; tmp <= dvd; tmp <<= 1, cnt <<= 1) {
                dvd -= tmp;
                rst += cnt;
            }
        }

        if (dividend < 0 ^ divisor < 0) {
            rst *= -1;
        }
        if (rst < Integer.MIN_VALUE || rst > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) rst;
    }
}

package Leetcode;
/**
 *
 * @author xiangfeidong
 *
 * Try to find greatest n that dividend >= divisor*(2^n), add n to result, and dividend -= 2^n
 * Keep trying while dividend >= divisor.
 * Example: 15 / 3.
 * Try: (1) 15 >= 3
 *          15 >= 6   (3<<1)
 *          15 >= 12  (3<<2)      res += 4  (1<<2)
 *      (2) (15 - 12 = 3)
 *          3 >= 3                res += 1
 *      (3) (3 - 3 = 0)
 * res = 5
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //Convert input to long type.
        long dvd = dividend;
        long dvs = divisor;
        boolean negative = (dvd < 0) ^ (dvs < 0) ? true : false;

        //Must take place after converting to long, in case that dividend=MIN_INT.
        dvd = Math.abs(dvd);
        dvs = Math.abs(dvs);

        int res = 0;
        while (dvd >= dvs) {
            long temp = dvs;
            int multiplier = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiplier <<= 1;
            }

            dvd -= temp;
            res += multiplier;
        }

        return negative ? -res : res;
    }
}

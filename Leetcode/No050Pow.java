package Leetcode;
/**
 * @author xiangfeidong
 *
 * 50.Pow(x, n)
 *
 * (1) n = 0: return 1
 * (2) n > 0: if n is even, return pow(x,n/2) * pow(x,n/2)
 *            if n is odd, return pow(x,n/2) * pow(x,n/2) * x
 * (3) n < 0: if n is even, return pow(x,n/2) * pow(x,n/2)
 *            if n is odd, return pow(x,n/2) * pow(x,n/2)/x
 */
public class No050Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else if (n > 0) {
            return temp * temp * x;
        } else {
            return temp * temp / x;
        }
    }
}

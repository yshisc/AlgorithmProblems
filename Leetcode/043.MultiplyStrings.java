package Leetcode;
/**
 * @author xiangfeidong
 *
 * 43.Multiply Strings
 *
 * Directly mutiple two numbers might cause overflow
 * Start with multiple with hand, for example num1=385  num2=97
 *       3 8 5             If we do not consider the carrier,
 *     *   9 7              We can see that 5 * 7 becomes the first digit of result.
 *--------------             And 8 * 7 + 9 * 5 becomes the second digit of result.
 *     2 6 9 5                ...
 * + 3 4 6 5               So we can create an array to record the product of single digits pair from num1 and num2.
 *--------------            And if num1 and num2 have m and n digits, then the result digits will be 1 ~ m+n
 *   3 7 3 4 5               Because for example 0 = 0*0 <= num1*num2 <= 99*999 < 100000
 *                            So we create an array with length of m+n
 *                             And from left to right, (ith char at num1)*(jth char at num2) should be recorded at [i+j+1]
 *
 *                         Then we handle the carrier, making every element in array less than 10
 *                          And transform the array to a string
 *                           Finally remove ahead 0s from the string
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        //Record product of num1[i] and num2[j] in product[i+j+1].
        int[] product = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                product[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        //Handle carry.
        int carry = 0;
        for (int k = product.length - 1; k >= 0; k--) {
            int temp = (product[k] + carry) % 10;
            carry = (product[k] + carry) / 10;
            product[k] = temp;
        }

        //Convert product array to StringBuilder.
        StringBuilder sb = new StringBuilder();
        for (int num : product) {
            sb.append(num);
        }

        //Delete preceding 0s.
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        //The result may be 0.
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

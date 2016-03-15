package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 60.Permutation Sequence
 *
 * Say we want to find 13th (0-based) permutation of {1,2,3,4}.
 *
 * 1. Permutations of {1,2,3,4} can be represented as
 *      (0) 1 + {permutations of 2,3,4}
 *      (1) 2 + {permutations of 1,3,4}
 *      (2) 3 + {permutations of 1,2,4}
 *      (3) 4 + {permutations of 1,2,3}
 *      There are 3! permutations of 3 numbers.
 *    13th permutation is in (2), because 13/3! = 2.
 *    So first number of result is 3.
 * 2. Now we look for 13 - 2*3! = 1th permutation of {1,2,4}
 *    Permutations of {1,2,4} can be represented as
 *      (0) 1 + {permutations of 2,4}
 *      (1) 2 + {permutations of 1,4}
 *      (2) 4 + {permutations of 1,2}
 *      There are 2! permutations of 2 numbers.
 *    1th permutation is in (0), because 1/2! = 0.
 *    So second number of result is 1.
 * 3. Now we look for 1 - 0*2! = 1th permutation of {2,4}
 *    Since 1 / 1! = 1, third number of result is 4.
 * 4. Now we look for 1 - 1*1! = 0th permutation of {4}
 *    Fourth number of result is 2.
 *
 * So result = 3142.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        //Get factorials of 0,1,...,n-1
        int[] factorials = calFactorials(n);

        //Get list of 1,3,...,n
        List<Integer> numbers = getNumbers(n);

        //Make k 0-based
        k--;

        StringBuilder sb = new StringBuilder();
        //Look for ith number of result
        for (int i = 1; i <= n; i++) {
            int index = k / factorials[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorials[n - i];
        }

        return sb.toString();
    }

    private int[] calFactorials(int n) {
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        return factorials;
    }

    private List<Integer> getNumbers(int n) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}

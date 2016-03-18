package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 89.Gray Code
 *
 * n=0      0
 * n=1      0->1
 * n=2      00->01->11->10
 * We want to find an algorithm that can get gray code of n from gray code of n-1
 * for n=3, if we add 0 and 1 on n=2, we get
 *          000->001->011->010
 *          100->101->111->110
 * We can find that numbers in each list vary in one bit, and last number of the two list vary in one bit.
 * So to get gray code of n, we can add 0 to gray code of n-1 from left to right (ie itself), and add 1 from right to left.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();

        list.add(0);

        for (int i = 1; i <= n; i++) {
            List<Integer> newList = new ArrayList<>();
            //Add 0 from left to right.
            newList.addAll(list);
            //Add 1 from right to left.
            for (int j = list.size() - 1; j >= 0; j--) {
                newList.add(list.get(j) + (1 << (i - 1)));
            }
            list = newList;
        }

        return list;
    }
}

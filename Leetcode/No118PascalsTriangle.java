package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 118.Pascal's Triangle
 */
public class No118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }

        //Generate first row.
        res.add(new ArrayList<>(Arrays.asList(1)));

        //Generate second to numRows rows.
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            //Add first number in ith row.
            list.add(1);

            //Add second number to (i-2)th number in ith row.
            for (int j = 1; j < i; j++) {
                list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }

            //Add last number in ith row
            list.add(1);

            res.add(list);
        }

        return res;
    }
}

package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 120.Triangle
 */
public class No120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> minPath = new ArrayList<>(triangle.get(n - 1));

        //For each row from bottom to top, except last row.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //Select smaller one from children, add current value.
                minPath.set(j, Math.min(minPath.get(j), minPath.get(j + 1)) + triangle.get(i).get(j));
            }
        }

        return minPath.get(0);
    }
}

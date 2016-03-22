package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 119.Pascal's Triangle II
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}

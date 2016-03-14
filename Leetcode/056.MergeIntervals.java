package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 56.Merge Intervals
 *
 * Sort intervals by start.
 * While we traverse intervals, record previous interval.
 * If current interval's end <= pre interval's start, merge the two intervals.
 * Else, the two intervals have no intersection, add pre interval to result.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        //Sort intervals by start.
        intervals.sort(new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) {
                //Merge pre and cur interval.
                pre.end = Math.max(cur.end, pre.end);
            } else {
                //Add pre interval to result, and update pre as cur.
                res.add(pre);
                pre = cur;
            }
        }
        //Add last interval.
        res.add(pre);

        return res;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiangfeidong
 *
 * 57.Insert Interval
 *
 * For a interval in list, compare to to-be-inserted interval, it may be:
 *     (1)at left, just add it to new list.
 *     (2)at right, just add it to new list.
 *     (3)has intersection, merge them,  and update start & end of to-be-inserted interval.
 * After traversal, we insert to-be-inserted interval to list. Insertion position = numbers of intervals at its left.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();

        //Init insertion position as 0.
        int insertPosition = 0;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                //The interval is at left of new interval.
                res.add(interval);
                //Increment insertion position. Insertion position = numbers of intervals at its left.
                insertPosition++;

            } else if (interval.start > newInterval.end) {
                //The interval is at right of new interval.
                res.add(interval);

            } else {
                //The interval has intersection with new interval, merge them, and update start & end of new interval.
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        //Insert new interval.
        res.add(insertPosition, newInterval);

        return res;
    }
}

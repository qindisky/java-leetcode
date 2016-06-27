package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]. 
 * 
 * @author qindi
 *
 */
public class _56MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        
        if (null == intervals || intervals.isEmpty()) {
            return list;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        
        System.out.println(intervals);
        
        Interval pre = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                if (pre.end < cur.end) {
                    pre.end = cur.end;
                }
            } else {
                list.add(pre);
                pre = cur;
            }
        }
        
        list.add(pre);
        
        return list;
    }
    
    public static void main(String[] args) {
        _56MergeIntervals solution = new _56MergeIntervals();
        System.out.println(solution.merge(Arrays.asList(new Interval(1,3),
                                                        new Interval(2,6),
                                                        new Interval(0,4),
                                                        new Interval(8,10),
                                                        new Interval(15,18))));
    }
}

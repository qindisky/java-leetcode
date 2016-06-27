package com.leetcode.qindipku.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 * 
 * @author qindi
 *
 */
public class _57InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        
        for (Interval interval : intervals) {
            if (newInterval.end < interval.start) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.end >= newInterval.start || newInterval.end >= interval.start) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        
        result.add(newInterval);
        
        return result;
    }
    
    public static void main(String[] args) {
        _57InsertInterval solution = new _57InsertInterval();
        System.out.println(solution.insert(Arrays.asList(new Interval(1,3),
                                                        new Interval(2,6),
                                                        new Interval(8,10),
                                                        new Interval(15,18)), new Interval(0,0)));

        System.out.println(solution.insert(Arrays.asList(new Interval(1,3),
                new Interval(2,6),
                new Interval(8,10),
                new Interval(15,18)), new Interval(19,20)));
        
        System.out.println(solution.insert(new ArrayList<Interval>(), new Interval(0,0)));
    }
}



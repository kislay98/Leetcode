package org.kislay.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedList = new LinkedList<>();
        int currentElementStart = intervals[0][0];
        int currentElementEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if (currentElementEnd >= intervals[i][0]) {
                currentElementEnd = Math.max(currentElementEnd, intervals[i][1]);
            } else {
                mergedList.add(new int[]{currentElementStart, currentElementEnd});
                currentElementStart = intervals[i][0];
                currentElementEnd = intervals[i][1];
            }
        }
        mergedList.add(new int[]{currentElementStart, currentElementEnd});
        return mergedList.toArray(new int[mergedList.size()][2]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        mergeIntervals.merge(intervals);
    }
}

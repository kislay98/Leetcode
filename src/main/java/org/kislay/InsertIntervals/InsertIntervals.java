package org.kislay.InsertIntervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }

        if (intervals.length == 1) {
            int start = newInterval[0];
            int end = newInterval[1];
            int givingEnd = intervals[0][1];
            int givingStart = intervals[0][0];
            if (start <= intervals[0][0] && start >= intervals[0][1]) {
                givingEnd = Math.max(newInterval[1], intervals[0][1]);
            }
            if (end <= intervals[0][0] && end >= intervals[0][1]) {
                givingStart = Math.min(newInterval[0], intervals[0][0]);
            }
            int[] ints = {givingStart, givingEnd};
            return new int[][] { ints };
        }

        int currPos = 0;
        List<int[]> newIntervals = new ArrayList<>();
        while (currPos < intervals.length) {
            int[] currInterval = intervals[currPos];
            if (currInterval[1] < newInterval[0]) {
                newIntervals.add(currInterval);
            } else {
                break;
            }
            currPos++;
        }
        int newIntervalStart = Math.min(newInterval[0], intervals[currPos][0]);
        int newIntervalEnd = newInterval[1];

        while (currPos < intervals.length) {
            int[] currInterval = intervals[currPos];
            if (currInterval[0] < newInterval[1]) {
                currPos++;
                // do nothing
            } else if (currInterval[0] == newInterval[1]) {
                newIntervalEnd = currInterval[1];
                currPos++;
                break;
            } else {
                break;
            }
        }
        newIntervals.add(new int[] { newIntervalStart, newIntervalEnd });
        while (currPos < intervals.length) {
            int[] currInterval = intervals[currPos];
            newIntervals.add(currInterval);
            currPos++;
        }
        return newIntervals.toArray(new int[newIntervals.size()][]);
    }

    public static void main(String[] args) {
        InsertIntervals intervals = new InsertIntervals();
        int[][] intervals1 = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] intervals2 = {4, 8};
        intervals.insert(intervals1, intervals2);
    }

}

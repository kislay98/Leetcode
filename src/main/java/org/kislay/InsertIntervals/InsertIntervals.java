package org.kislay.InsertIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int toAddIntervalStartPoint = newInterval[0];
        int toAddIntervalEndPoint = newInterval[1];
        int intervalsLength = intervals.length;
        if (intervalsLength == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int[][] newIntervals = new int[intervalsLength+1][2];
        int currIntervalIdx = 0;
        int newIntervalIdx = 0;


        while (intervals[currIntervalIdx][1] < toAddIntervalStartPoint) {
            newIntervals[newIntervalIdx++] = intervals[currIntervalIdx];
            currIntervalIdx++;
            if (currIntervalIdx == intervalsLength) {
                break;
            }
        }

        int newIntervalStartPoint;
        if (currIntervalIdx == intervalsLength) {
            newIntervalStartPoint = toAddIntervalStartPoint;
        } else newIntervalStartPoint = Math.min(intervals[currIntervalIdx][0], toAddIntervalStartPoint);

        int newIntervalEndPoint;
        while (currIntervalIdx < intervalsLength && intervals[currIntervalIdx][1] <= toAddIntervalEndPoint) {
            currIntervalIdx++;
            if (currIntervalIdx == intervalsLength) {
                break;
            }
        }
        if (currIntervalIdx == intervalsLength) {
            newIntervalEndPoint = toAddIntervalEndPoint;
        } else if (intervals[currIntervalIdx][0] <= toAddIntervalEndPoint) {
            newIntervalEndPoint = intervals[currIntervalIdx][1];
            currIntervalIdx++;
        } else {
            newIntervalEndPoint = toAddIntervalEndPoint;
        }

        newIntervals[newIntervalIdx++] = new int[] {newIntervalStartPoint, newIntervalEndPoint};
        while (currIntervalIdx < intervalsLength) {
            newIntervals[newIntervalIdx++] = intervals[currIntervalIdx];
            currIntervalIdx++;
        }

        return Arrays.copyOf(newIntervals, newIntervalIdx);
    }

    public static void main(String[] args) {
        InsertIntervals intervals = new InsertIntervals();
        int[][] intervals1 = {
                {1, 5}
        };
        int[] intervals2 = {6, 8};
        intervals.insert(intervals1, intervals2);
    }

}

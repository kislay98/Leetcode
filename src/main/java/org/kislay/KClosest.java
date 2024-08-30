package org.kislay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {

    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return new int[0][0];
        }
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(n, Comparator.comparingInt(a -> a[0]*a[0] + a[1]*a[1]));
        for (int[] point : points) {
            pq.offer(point);
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}

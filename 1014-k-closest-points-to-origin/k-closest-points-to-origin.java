import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }

    private int distance(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}
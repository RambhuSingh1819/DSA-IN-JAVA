class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        long need = 1L * m * k;           // prevent overflow
        if (need > n) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int d : bloomDay) {
            if (d < low)  low = d;
            if (d > high) high = d;
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;           // feasible → try smaller
                high = mid - 1;
            } else {
                low = mid + 1;       // not feasible → need more days
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int days, int m, int k) {
        int bouquets = 0, run = 0;
        for (int d : arr) {
            if (d <= days) {
                run++;
                if (run == k) {
                    bouquets++;
                    if (bouquets >= m) return true; // early exit
                    run = 0;
                }
            } else {
                run = 0;
            }
        }
        return bouquets >= m;
    }
}

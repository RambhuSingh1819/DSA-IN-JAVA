class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDivide(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canDivide(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // ceiling division
            if (sum > threshold) return false;    // early stop
        }
        return sum <= threshold;
    }
}

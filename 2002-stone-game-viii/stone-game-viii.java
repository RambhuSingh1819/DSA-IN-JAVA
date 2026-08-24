class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Compute prefix sums in-place
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }
        
        // Base case: at the last index, the player must take all remaining prefix sum
        int maxDiff = stones[n - 1];
        
        // Work backwards from n - 2 down to index 1
        for (int i = n - 2; i >= 1; i--) {
            // maxDiff is max(skip current index, take current prefix sum - opponent's maxDiff)
            maxDiff = Math.max(maxDiff, stones[i] - maxDiff);
        }
        
        return maxDiff;
    }
}
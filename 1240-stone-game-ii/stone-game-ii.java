class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        // suffixSum[i] stores the sum of all piles from index i to the end
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        // dp[i][M] stores the max stones a player can get starting at index i with multiplier M
        // M cannot exceed n, so size n+1 for the second dimension is sufficient.
        int[][] dp = new int[n][n + 1]; 
        
        return solve(0, 1, piles, suffixSum, dp);
    }
    
    private int solve(int i, int M, int[] piles, int[] suffixSum, int[][] dp) {
        // Base Case: If we reach the end, no stones left to take
        if (i >= piles.length) {
            return 0; 
        }
        
        // Base Case: If we can take all the remaining piles
        if (i + 2 * M >= piles.length) {
            return suffixSum[i]; 
        }
        
        // Return precalculated value if we have already visited this state
        if (dp[i][M] != 0) {
            return dp[i][M]; 
        }
        
        int maxStones = 0;
        
        // Try taking X piles, where 1 <= X <= 2M
        for (int x = 1; x <= 2 * M; x++) {
            // Our stones = total remaining stones - opponent's max stones on their turn
            int opponentScore = solve(i + x, Math.max(M, x), piles, suffixSum, dp);
            maxStones = Math.max(maxStones, suffixSum[i] - opponentScore);
        }
        
        return dp[i][M] = maxStones;
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row,-1);

        int ans =  solve(n-1,coins,amount,dp);
        return (ans == 1e9) ? -1 : ans;
    }
    public int solve(int idx, int[] a, int k,int[][]dp){
        if(idx == 0){
            if(k % a[0] == 0) return k/a[0];
            else return (int)1e9;
        }
        if(dp[idx][k] != -1) return dp[idx][k];
        int notTake = solve(idx-1,a,k,dp);
        int Take = (int)1e9;
        if(a[idx] <= k) Take = 1 + solve(idx,a,k-a[idx],dp);
        return dp[idx][k] = Math.min(notTake, Take);
    }
}
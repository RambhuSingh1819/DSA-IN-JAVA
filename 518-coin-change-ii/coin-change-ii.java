class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] ele : dp ) Arrays.fill(ele,-1);
        return solve(n-1,amount,coins,dp);
    }
    public int solve(int idx, int k, int[] arr,int[][] dp){
        if(idx == 0){
            if(k % arr[0] == 0) return 1;
            else return 0;
        }
        if(k == 0) return 1;
        if(dp[idx][k] != -1) return dp[idx][k];
        int notTake = solve(idx-1,k,arr,dp);
        int Take = 0;
        if(arr[idx] <= k){
            Take = solve(idx,k-arr[idx],arr,dp);
        }
        return dp[idx][k] = Take+notTake;
    }
}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
        
    }
    public int solve(int n , int[] nums ,int[] dp){
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0],nums[1]);
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max(nums[n]+solve(n-2, nums, dp),solve(n-1, nums, dp));
    }
}